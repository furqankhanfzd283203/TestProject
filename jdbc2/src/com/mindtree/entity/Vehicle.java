package com.mindtree.entity;

public class Vehicle {
	private String vehicleName;
	private String vehicleRegistrationMonth;
	private String state;
	private Customer customer;

	public Vehicle() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Vehicle(String vehicleName, String vehicleRegistrationMonth, String state, Customer customer) {
		super();
		this.vehicleName = vehicleName;
		this.vehicleRegistrationMonth = vehicleRegistrationMonth;
		this.state = state;
		this.customer = customer;
	}
	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((vehicleName == null) ? 0 : vehicleName.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Vehicle other = (Vehicle) obj;
		if (vehicleName == null) {
			if (other.vehicleName != null)
				return false;
		} else if (!vehicleName.equals(other.vehicleName))
			return false;
		return true;
	}

	public String getVehicleName() {
		return vehicleName;
	}

	public void setVehicleName(String vehicleName) {
		this.vehicleName = vehicleName;
	}

	public String getVehicleRegistrationMonth() {
		return vehicleRegistrationMonth;
	}

	public void setVehicleRegistrationMonth(String vehicleRegistrationMonth) {
		this.vehicleRegistrationMonth = vehicleRegistrationMonth;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

}
