package com.dispatch.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dispatch.entity.OrderEntity;
import com.dispatch.repository.DispatchRepository;

@Service
public class DispatchService {

	@Autowired
	private DispatchRepository dispatchRepo;
	
	public boolean orderDispatch(long id) {
		
		if( dispatchRepo.updateStatusDispatch(id)>0) {
			return true;
		}else {
			return false;
		}
	}
	
	public List<OrderEntity> getAllPendingOrders(){
		return this.dispatchRepo.getAllPendingOrders();
	}
	
	
}
