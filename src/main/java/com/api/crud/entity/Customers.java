 package com.api.crud.entity;


	import javax.persistence.Column;
	import javax.persistence.Entity;
	import javax.persistence.GeneratedValue;
	import javax.persistence.GenerationType;
	import javax.persistence.Id;
	import javax.persistence.Table;

	@Entity
	@Table(name="cus")
	public class Customers {
	 
		@Id
		@GeneratedValue(strategy=GenerationType.AUTO)
		private long id;
		@Column(name="cus_name")
		private String customername;
		@Column(name="cus_address")
		private String customeraddress;
		@Column(name="cus_phno")
		private long phnnumber;
		
		public Customers()
		{
			
		}

		public Customers(String customername, String customeraddress, long phnnumber) {
			super();
			this.customername = customername;
			this.customeraddress = customeraddress;
			this.phnnumber = phnnumber;
		}

		public long getId() {
			return id;
		}

		public void setId(long id) {
			this.id = id;
		}

		public String getCustomername() {
			return customername;
		}

		public void setCustomername(String customername) {
			this.customername = customername;
		}

		public String getCustomeraddress() {
			return customeraddress;
		}

		public void setCustomeraddress(String customeraddress) {
			this.customeraddress = customeraddress;
		}

		public long getPhnnumber() {
			return phnnumber;
		}

		public void setPhnnumber(long phnnumber) {
			this.phnnumber = phnnumber;
		}

}
