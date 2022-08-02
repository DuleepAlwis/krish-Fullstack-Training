package com.fuel.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.fuel.entity.OrderEntity;
import com.fuel.repository.OrderRepository;

@Service
public class OrderService {

	@Autowired
	OrderRepository orderRepo;
	
	@Autowired
	private KafkaTemplate<String, String> kafkaTemplate;

	@Value("${topic.name.producer}")
    private String topicName;

	
	public void sendMessage(String orderId) {
	    kafkaTemplate.send(topicName, orderId);
	}
	
	public boolean OrderSave(OrderEntity order) {
		
		OrderEntity res = orderRepo.save(order);
		if(res!=null) {
			sendMessage(String.valueOf(res.getId()));
			return true;
		}
		else {
			return false;
		}
		
	}
	
	public List<OrderEntity> getPendingOrders(){
		return this.orderRepo.getPendingOrders();
	}
}
