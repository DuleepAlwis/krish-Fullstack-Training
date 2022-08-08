package com.dispatch.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.dispatch.entity.OrderEntity;
import com.dispatch.repository.DispatchRepository;

@Service
public class DispatchService {

	@Autowired
	private DispatchRepository dispatchRepo;
	
	@Value("${topic.name.consumer}")
    private String topicName;
	
	@Autowired
	private KafkaTemplate<String, String> kafkaTemplate;

	
	public boolean orderDispatch(long id) {
		
		if( dispatchRepo.updateStatusDispatch(id)>0) {
			sendMessage("Order dispatch for order id "+String.valueOf(id));
			return true;
		}else {
			return false;
		}
	}
	
	public List<OrderEntity> getAllPendingOrders(){
		return this.dispatchRepo.getAllPendingOrders();
	}
	
	public void sendMessage(String msg) {
	    kafkaTemplate.send(topicName, msg);
	}
	
}
