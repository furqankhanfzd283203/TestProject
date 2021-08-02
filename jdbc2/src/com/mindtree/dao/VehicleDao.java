package com.mindtree.dao;

import java.util.Set;

import com.mindtree.entity.Vehicle;
import com.mindtree.exception.DaoException;

public interface VehicleDao {

	Set<Vehicle> getAllVehicle() throws DaoException;

	Set<Vehicle> getAllCustomersWithVehicle() throws DaoException;

	Set<Vehicle> insertVehicleIntoDB(Set<Vehicle> vehicleSet, byte id) throws DaoException;

}
