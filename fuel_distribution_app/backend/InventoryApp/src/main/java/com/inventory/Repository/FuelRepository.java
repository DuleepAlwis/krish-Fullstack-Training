package com.inventory.Repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.inventory.entity.FuelProp;

public interface FuelRepository extends JpaRepository<FuelProp,Long> {

	@Query(value="select * from fuel_props where name='Available_Stock'",nativeQuery=true)
	public FuelProp getFuelAvailable();
	
	@Modifying
    @Transactional 
	@Query(value="update fuel_props set stock_amount = ?1 where name='Available_Stock'",nativeQuery=true)
	public int updateAvailableFuel(float amount);
	
	@Modifying
    @Transactional 
	@Query(value="update fuel_props set stock_amount = stock_amount + ?1 where name='Reserved_Stock'",nativeQuery=true)
	public int updateReservedFuel(float amount);
	
	//Fuel need to be allocated status = 0
	@Modifying
    @Transactional 
	@Query(value="update order_tb set status = 0 where id=?1",nativeQuery=true)
	public int updateFuelAllocationToOrder(long id);
}
