package com.inventory.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="app_props")
public class ApplicationProps {

	@Id
	 @GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@Column(name="property")
	private String property;
	
	@Column(name="value")
	private String value;

	public ApplicationProps() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ApplicationProps(long id, String property, String value) {
		super();
		this.id = id;
		this.property = property;
		this.value = value;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getProperty() {
		return property;
	}

	public void setProperty(String property) {
		this.property = property;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return "ApplicationProps [id=" + id + ", property=" + property + ", value=" + value + "]";
	}
	
	
	
}