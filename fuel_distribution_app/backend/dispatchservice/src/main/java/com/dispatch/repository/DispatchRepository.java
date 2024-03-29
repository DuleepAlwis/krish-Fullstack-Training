package com.dispatch.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.dispatch.entity.OrderEntity;

@Repository
public interface DispatchRepository extends JpaRepository<OrderEntity,Long>{

	//Delivery sheduled status =2
	@Modifying
	@Transactional
	@Query(value="update order_tb set status = 2 where id = ?1", nativeQuery= true)
	public int updateStatusDispatch(long id);
	
	@Query(value="select * from order_tb where status=1",nativeQuery = true)
	public List<OrderEntity> getAllPendingOrders();
}
