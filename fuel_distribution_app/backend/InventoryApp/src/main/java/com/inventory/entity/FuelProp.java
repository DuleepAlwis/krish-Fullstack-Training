package com.inventory.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="fuel_props")
public class FuelProp {

	@Id
	 @GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@Column(name="name")
	private String name;
	
	@Column(name="stock_amount")
	private float stock;

	public FuelProp() {
		super();
		// TODO Auto-generated constructor stub
	}

	public FuelProp(long id, String name, float stock) {
		super();
		this.id = id;
		this.name = name;
		this.stock = stock;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public float getStock() {
		return stock;
	}

	public void setStock(float stock) {
		this.stock = stock;
	}

	@Override
	public String toString() {
		return "FuelProp [id=" + id + ", name=" + name + ", stock=" + stock + "]";
	}
	
	
	
		
}
