const mysql = require('mysql');
const express = require('express');
var app = express();
const bodyparser = require('body-parser');
//var kafka = require('./kafkatemplate')

const cors = require('cors');

const { Kafka } = require('kafkajs')



  



/************************************************************************ */
app.use(cors({
    origin: 'http://localhost:4200'
}));

const kafka = new Kafka({
    clientId: 'Node-KafkaProduceConsumer',
    brokers: ['localhost:9092']
})

const producer = kafka.producer()


app.use(bodyparser.json());

var mysqlConnection = mysql.createConnection({
    host: 'localhost',
    port: '3306',
    user: 'root',
    password: 'password',
    database: 'fuel_distribution_db'
});

mysqlConnection.connect((err) => {
    if (!err) {
        console.log('DB Connection succesfull!')
    } else {
        console.log('DB Connection failed! \n Error:' + JSON.stringify(err, undefined, 2));
    }
});

app.listen(8083, () => console.log('Express server is running at port:8083'));
// kafka.run();
//Update order
app.put('/shedule/allocateVehicle/:id', (req, res) => {
    let id = req.params.id;
    var sql = "UPDATE order_tb SET status = 3 WHERE id = ?";
    mysqlConnection.query(sql, [id], (err, rows, fields) => {
        if (!err) {
            res.send(true);
            //alert('Updated successfully')
            //kafka.send('Delivery sheduled');
         /************************************* */
         const run = async () => {
            // Producing
            await producer.connect()
            await producer.send({
                topic: 'DispatchOrder',
                messages: [{
                    value: 'Order id '+id+' Delivery sheduled'
                }]
            });
        }
        run().catch((e) => console.error(e));
         /************************************** */
        }
        else {
            //alert('Oops there is an error!' + err)
            console.log(err);
        }
    })
});

