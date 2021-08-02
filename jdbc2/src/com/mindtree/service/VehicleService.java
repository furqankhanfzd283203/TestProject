package com.mindtree.service;

import java.util.Set;

import com.mindtree.entity.Vehicle;
import com.mindtree.exception.ServiceException;

public interface VehicleService {

	Set<Vehicle> getAllVehicle() throws ServiceException;

	Set<Vehicle> getAllCustomersWithVehicle() throws ServiceException;

	Set<Vehicle> insertVehicleIntoDB(Set<Vehicle> vehicleSet, byte id) throws ServiceException;

}
