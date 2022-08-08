package com.inventory.InventoryApp;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.inventory.Repository.FuelRepository;
import com.inventory.Repository.OrderRepository;
import com.inventory.entity.FuelProp;
import com.inventory.entity.OrderEntity;

@Service
public class InventoryListener {

	@Autowired 
	FuelRepository fuelRepo;
	
	@Autowired
	OrderRepository orderRepo;
	
	@Value("${topic.name.consumer}")
    private String topicName;
	
	@Autowired
	private KafkaTemplate<String, String> kafkaTemplate;

    @KafkaListener(topics = "${topic.name.consumer}", groupId = "group_id")
    public void consume(ConsumerRecord<String, String> payload){
		/*
		 * System.out.println("Tópico: {}"+ topicName); System.out.println("key: {}"+
		 * payload.key()); System.out.println("Headers: {}"+ payload.headers());
		 * System.out.println("Partion: {}"+ payload.partition());
		 */
    	System.out.println("Order id "+payload.value());
    	
    	if(payload.value().contains("Allocation")){
    		return;
    	}
    	Long id = Long.parseLong(payload.value());
    	
    	OrderEntity orderEnt = orderRepo.getOrderDetails(id);
    	
    	FuelProp fuelEnt = fuelRepo.getFuelAvailable();
    	
    	float remainingFuel = fuelEnt.getStock()-orderEnt.getAmount_needed();
    	
    	if(remainingFuel>=0) {
    		fuelRepo.updateReservedFuel(orderEnt.getAmount_needed());
        	fuelRepo.updateAvailableFuel(remainingFuel);
        	
        	
        	sendMessage("Allocation done for the order id "+String.valueOf(orderEnt.getId()));
    	}else {
    		fuelRepo.updateFuelAllocationToOrder(id);
        	sendMessage("Allocation not done for the order id "+String.valueOf(orderEnt.getId())+ " because remaining fuel not sufficient");

    	}
    	
    	
    	
    	
    	
    }
    
    public void sendMessage(String msg) {
	    kafkaTemplate.send(topicName, msg);
	}
}
