package com.dispatch.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.dispatch.entity.OrderEntity;
import com.dispatch.service.DispatchService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/dispatch")
public class DispatchController {

	@Autowired
	private DispatchService dispatchService;
	
	@RequestMapping(value="/order/{id}",method=RequestMethod.PUT)
	public boolean dispatchOrder(@PathVariable long id) {
		
		return dispatchService.orderDispatch(id);
	}
	
	@RequestMapping(value="/pendingDeliveryOrders",method=RequestMethod.GET)
	public List<OrderEntity> pendingDeliveryOrders(){
		System.out.println("Hello world");
		return this.dispatchService.getAllPendingOrders();
	}
}
