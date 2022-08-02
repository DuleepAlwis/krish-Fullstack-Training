package com.fuel.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.fuel.entity.OrderEntity;


@Repository
public interface OrderRepository extends JpaRepository<OrderEntity,Long>{

	@Query(value="select * from order_tb where status=0", nativeQuery=true)
	public List<OrderEntity> getPendingOrders();
	
}
