package com.fuel.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.fuel.entity.OrderEntity;


@Repository
public interface OrderRepository extends JpaRepository<OrderEntity,Long>{

	@Query(value="select * from order_tb", nativeQuery=true)
	public List<OrderEntity> getPendingOrders();
	
	@Query(value="select * from order_tb" , nativeQuery=true)
	public List<OrderEntity> getAllOrders();

	//Delivery pending status = 1
	@Modifying
    @Transactional 
	@Query(value="update order_tb set status = 1 where id=?1",nativeQuery=true)
	public int updateFuelAllocation(long id);
	
	@Modifying
	@Transactional
	@Query(value="delete from order_tb where id = ?1" ,nativeQuery=true)
	public int removeOrder(long id);
}
