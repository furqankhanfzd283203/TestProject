package com.mindtree.client;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

import com.mindtree.entity.Customer;
import com.mindtree.entity.Vehicle;
import com.mindtree.exception.ApplicationException;
import com.mindtree.exception.ServiceException;
import com.mindtree.service.CustomerService;
import com.mindtree.service.VehicleService;
import com.mindtree.service.impl.CustomerServiceImpl;
import com.mindtree.service.impl.VehicleServiceImpl;

public class VehicleRegistrationSystem {
	private static final VehicleService vehicleService = new VehicleServiceImpl();
	private static final CustomerService customerService = new CustomerServiceImpl();

	private static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {
		byte choice = 0;
		try {
			do {
				choice = menuChoice();

				switch (choice) {

				case 1:
					addVehicleToCustomer();
					break;

				case 2:
					displayAllCustomersWithVehicle();
					break;
				case 3:
					displayAllSortedCustomersWithVehicle();
					break;

				case 4:
					System.out.println("you are Exit");
					break;
				default:
					System.out.println("you enter invalid choice");
				}
			} while (choice != 4);
		} catch (ApplicationException e) {
			System.out.println(e.getMessage());
		}
	}

	private static byte menuChoice() {

		System.out.println("1:add vehicle to customer");

		System.out.println("2:Display a vehicle and show all male customer in sorted order by name");
		System.out.println("3:Display all sorted vehicle with customer details based on state as well as vahicle name");

		System.out.println("4:Exit");
		System.out.println("enter your choice");
		byte choice = scan.nextByte();
		return choice;
	}

	private static void addVehicleToCustomer() throws ApplicationException {
		System.out.println("enter customer id");

		byte id = scan.nextByte();
		try {
			Customer customer = customerService.checkCustomer(id);

			Set<Vehicle> vehicleSet = assignVehicleToCustomer(customer);
			Set<Vehicle> vehicleSet1 = vehicleService.insertVehicleIntoDB(vehicleSet, id);
			displayVehicleSet(vehicleSet1);
		} catch (ServiceException e) {
			throw new ApplicationException("error occure", e);
		}
	}

	private static Set<Vehicle> assignVehicleToCustomer(Customer customer) {
		System.out.println("How many vehicle you want to add");
		byte input = scan.nextByte();
		Set<Vehicle> vehicleSet = new LinkedHashSet<Vehicle>();
		for (int i = 0; i < input; i++) {

			System.out.println("enter name");
			String name = scan.next();
			System.out.println("enter vehicle registration month");
			String month = scan.next();
			System.out.println("enter state");
			String state = scan.next();

			vehicleSet.add(new Vehicle(name, month, state, customer));
		}

		return vehicleSet;
	}

	private static void displayVehicleSet(Set<Vehicle> vehicleSet) {

		for (Vehicle vehicle : vehicleSet) {
			System.out.println(vehicle.getVehicleName() + " " + vehicle.getVehicleRegistrationMonth() + " "
					+ vehicle.getState() + " " + vehicle.getCustomer().getCustomerName() + " "
					+ vehicle.getCustomer().getAge() + " " + vehicle.getCustomer().getGender());
		}
	}

	@FunctionalInterface
	interface displayVehivles {
		void displayVehicleList(List<Vehicle> vehicleList);
	}

	static displayVehivles display = (vehicleList) -> {

		for (Vehicle vehicle : vehicleList) {
			System.out.println(vehicle.getVehicleName() + " " + vehicle.getVehicleRegistrationMonth() + " "
					+ vehicle.getState() + " " + vehicle.getCustomer().getCustomerName() + " "
					+ vehicle.getCustomer().getAge() + " " + vehicle.getCustomer().getGender());
		}
	};

	/*
	 * private static void displayVehicleList(List<Vehicle> vehicleList) {
	 * 
	 * for (Vehicle vehicle : vehicleList) {
	 * System.out.println(vehicle.getVehicleName() + " "
	 * +vehicle.getVehicleRegistrationMonth() + " " +
	 * vehicle.getState()+" "+vehicle.getCustomer().getCustomerName()+" "
	 * +vehicle.getCustomer().getAge()+" "+vehicle.getCustomer().getGender()); }
	 * }
	 */
	private static void displayAllCustomersWithVehicle() throws ApplicationException {
		try {
			Set<Vehicle> vehicleSet = vehicleService.getAllCustomersWithVehicle();
			displayVehicleSet(vehicleSet);
		} catch (ServiceException e) {
			throw new ApplicationException("error occure", e);
		}
	}

	private static void displayAllSortedCustomersWithVehicle() throws ApplicationException {
		try {
			Set<Vehicle> vehicleSet = vehicleService.getAllVehicle();
			List<Vehicle> vehicleList = new ArrayList<Vehicle>(vehicleSet);
			Collections.sort(vehicleList, new CompareValues());
			display.displayVehicleList(vehicleList);
		} catch (ServiceException e) {
			throw new ApplicationException("error occure", e);
		}
	}
}

class CompareValues implements Comparator<Vehicle> {
	public int compare(Vehicle v1, Vehicle v2) {

		if (v1.getState().compareTo(v2.getState()) == 0)
			return v1.getVehicleName().compareTo(v2.getVehicleName());
		else
			return v1.getState().compareTo(v2.getState());

	}
}
