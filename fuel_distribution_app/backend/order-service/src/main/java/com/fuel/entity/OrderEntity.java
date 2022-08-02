package com.fuel.entity;


	import javax.persistence.Column;
	import javax.persistence.Entity;
	import javax.persistence.GeneratedValue;
	import javax.persistence.GenerationType;
	import javax.persistence.Id;
	import javax.persistence.Table;

	@Entity
	@Table(name="order_tb")
	public class OrderEntity {
		
		@Id
		 @GeneratedValue(strategy = GenerationType.AUTO)
		private long id;
		
		@Column(name="gas_station_name")
		private String gasStName;
		
		@Column(name="gas_station_id")
		private String gasStId;
		
		@Column(name="TYPE_of_fuel")
		private String typeOfFuel;
		
		@Column(name="amount_needed")
		private float amount_needed;
		
		@Column(name="status")
		private int status;

		@Column(name="city")
		private String city;
		
		@Column(name="district")
		private String district;
		
		@Column(name="address")
		private String address;

		public OrderEntity(long id, String gasStName, String gasStId, String typeOfFuel, float amount_needed, int status,
				String city, String district, String address) {
			super();
			this.id = id;
			this.gasStName = gasStName;
			this.gasStId = gasStId;
			this.typeOfFuel = typeOfFuel;
			this.amount_needed = amount_needed;
			this.status = status;
			this.city = city;
			this.district = district;
			this.address = address;
		}

		public OrderEntity() {
			super();
			// TODO Auto-generated constructor stub
		}

		public long getId() {
			return id;
		}

		public void setId(long id) {
			this.id = id;
		}

		public String getGasStName() {
			return gasStName;
		}

		public void setGasStName(String gasStName) {
			this.gasStName = gasStName;
		}

		public String getGasStId() {
			return gasStId;
		}

		public void setGasStId(String gasStId) {
			this.gasStId = gasStId;
		}

		public String getTypeOfFuel() {
			return typeOfFuel;
		}

		public void setTypeOfFuel(String typeOfFuel) {
			this.typeOfFuel = typeOfFuel;
		}

		public float getAmount_needed() {
			return amount_needed;
		}

		public void setAmount_needed(float amount_needed) {
			this.amount_needed = amount_needed;
		}

		public int getStatus() {
			return status;
		}

		public void setStatus(int status) {
			this.status = status;
		}

		public String getCity() {
			return city;
		}

		public void setCity(String city) {
			this.city = city;
		}

		public String getDistrict() {
			return district;
		}

		public void setDistrict(String district) {
			this.district = district;
		}

		public String getAddress() {
			return address;
		}

		public void setAddress(String address) {
			this.address = address;
		}

		@Override
		public String toString() {
			return "OrderEntity [id=" + id + ", gasStName=" + gasStName + ", gasStId=" + gasStId + ", typeOfFuel="
					+ typeOfFuel + ", amount_needed=" + amount_needed + ", status=" + status + ", city=" + city
					+ ", district=" + district + ", address=" + address + "]";
		}
}
