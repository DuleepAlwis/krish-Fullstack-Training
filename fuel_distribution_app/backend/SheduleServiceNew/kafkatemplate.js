const { Kafka } = require('kafkajs')

const kafka = new Kafka({
  clientId: 'DispatchServiceKafkatemplate',
  brokers: ['localhost:9092']
})

const producer = kafka.producer()
const consumer = kafka.consumer({ groupId: 'dispatchService' })

const run = async () => {
  // Producing
  await producer.connect()
  await producer.send({
    topic: 'DispatchOrder',
    messages: "Vehicle allocated",
  });

  // Consuming
  await consumer.connect()
  await consumer.subscribe({ topic: 'DispatchOrder', fromBeginning: true })

  await consumer.run({
    eachMessage: async ({ topic, partition, message }) => {
      console.log({
        partition,
        offset: message.offset,
        value: message.value.toString(),
      })
    },
  })
}

run().catch(console.error)

module.exports = {run};