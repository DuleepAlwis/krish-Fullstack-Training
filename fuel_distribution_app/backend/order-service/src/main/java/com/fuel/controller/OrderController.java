package com.fuel.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fuel.entity.OrderEntity;
import com.fuel.service.OrderService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/order")
public class OrderController {

	@Autowired
	private OrderService orderService;
	
	@RequestMapping(value="/save",method=RequestMethod.POST)
	public boolean save(@RequestBody OrderEntity order) {
		System.out.println(order);
		return orderService.OrderSave(order);
	}
	
	
	
	@RequestMapping(value="/pendingOrders", method=RequestMethod.GET)
	public List<OrderEntity> getPendingOrders(){
		return this.orderService.getPendingOrders();
	}
	
	@RequestMapping(value="/getAllOrders" , method=RequestMethod.GET)
	public List<OrderEntity> getAllOrders(){
		return this.orderService.getAllOrders();
	}
	
	
	@RequestMapping(value="/allocateFuel/{id}" , method=RequestMethod.PUT)
	public Boolean allocateFuel(@PathVariable long id){
		return this.orderService.updateAllocationFuel(id);
	}
	
	@RequestMapping(value="/removeOrder/{id}",method=RequestMethod.DELETE)
	public boolean removeOrder(@PathVariable long id) {
		return this.orderService.removeOrder(id);
	}
}
