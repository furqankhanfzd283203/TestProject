package com.mindtree.dao.impl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedHashSet;
import java.util.Set;

import com.mindtree.dao.VehicleDao;
import com.mindtree.entity.Customer;
import com.mindtree.entity.Vehicle;
import com.mindtree.exception.DaoException;
import com.mindtree.exception.UtilityException;
import com.mindtree.utility.DBConnection;

public class VehicleDaoImpl implements VehicleDao {

	@Override
	public Set<Vehicle> getAllVehicle() throws DaoException {
		// TODO Auto-generated method stub
		Set<Vehicle> vehicleSet = new LinkedHashSet<Vehicle>();
		String query = "select v.*,c.* from customer c inner join vehicle v on c.customerId=v.customerId;";
		Connection connection = null;
		PreparedStatement statement = null;
		try {

			connection = DBConnection.connectionToDB();

			statement = connection.prepareStatement(query);

			ResultSet resultSet = statement.executeQuery(query);
			while (resultSet.next()) {

				String name = resultSet.getString(2);
				String month = resultSet.getString(3);
				String state = resultSet.getString(4);
				String cName = resultSet.getString(7);
				String gender = resultSet.getString(8);
				int age = resultSet.getInt(9);
				Customer customer = new Customer(cName, gender, age);

				Vehicle vehicle = new Vehicle(name, month, state, customer);

				vehicleSet.add(vehicle);
			}

		} catch (UtilityException e) {
			throw new DaoException("problem with connection",e);
		} catch (SQLException e) {
			throw new DaoException("problem with query",e);
		} finally {
			try {
				statement.close();
				connection.close();
			} catch (SQLException e) {
				throw new DaoException("Resources not close properly",e);
			}
		}
		return vehicleSet;

	}

	@Override
	public Set<Vehicle> getAllCustomersWithVehicle() throws DaoException {
		Set<Vehicle> vehicleSet = new LinkedHashSet<Vehicle>();
		String query = "select v.*,c.* from customer c , vehicle v where c.customerId=v.customerId and c.gender='male' and vehicleRegistrationMonth='may'  order by vehicleName";
		Connection connection = null;
		PreparedStatement statement = null;
		try {
			
				connection = DBConnection.connectionToDB();
			

			statement = connection.prepareStatement(query);

			ResultSet resultSet = statement.executeQuery(query);
			while (resultSet.next()) {

				String name = resultSet.getString(2);
				String month = resultSet.getString(3);
				String state = resultSet.getString(4);
				String cName = resultSet.getString(7);
				String gender = resultSet.getString(8);
				int age = resultSet.getInt(9);
				Customer customer = new Customer(cName, gender, age);

				Vehicle vehicle = new Vehicle(name, month, state, customer);

				vehicleSet.add(vehicle);
			}

		}catch (UtilityException e) {
			throw new DaoException("problem with connection",e); 
		}
		catch (SQLException e) {
			throw new DaoException("problem with query",e);
		} finally {
			try {
				statement.close();
				connection.close();
			} catch (SQLException e) {
				throw new DaoException("Resources not close properly",e);
			}
		}
		return vehicleSet;

	}

	@Override
	public Set<Vehicle> insertVehicleIntoDB(Set<Vehicle> vehicleSet, byte id) throws DaoException {
		// TODO Auto-generated method stub
		Set<Vehicle> vehicleSets = new LinkedHashSet<Vehicle>();
		CallableStatement statement = null;
		Connection connection = null;

		try {
			connection = DBConnection.connectionToDB();
			for (Vehicle vehicle : vehicleSet) {
				String name = vehicle.getVehicleName();
				String month = vehicle.getVehicleRegistrationMonth();
				String state = vehicle.getState();

				String query = "call jdbc2_database.insertVehicles(?,?,?,?)";
				statement = connection.prepareCall(query);
				statement.setString(1, name);
				statement.setString(2, month);
				statement.setString(3, state);
				statement.setInt(4, id);

				int rowsInserted = statement.executeUpdate();
				if (rowsInserted > 0) {
					vehicleSets.add(new Vehicle(name, month, state, vehicle.getCustomer()));
				}
			}

		} catch (UtilityException e) {
			throw new DaoException("problem with connection",e);
		} catch (SQLException e) {
			//e.printStackTrace();
			throw new DaoException("problem with query",e);
		} finally {
			try {
				statement.close();
				connection.close();
			} catch (SQLException e) {
				throw new DaoException("Resources not close properly",e);
			}
		}

		return vehicleSets;
	}

}
