package com.inventory.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.inventory.entity.OrderEntity;

public interface OrderRepository extends JpaRepository<OrderEntity,Long>{

	@Query(value="select * from order_tb where id=?1", nativeQuery=true)
	public OrderEntity getOrderDetails(long id);
}
