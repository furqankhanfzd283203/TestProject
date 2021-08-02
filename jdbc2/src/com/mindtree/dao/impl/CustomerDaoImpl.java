package com.mindtree.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mindtree.dao.CustomerDao;
import com.mindtree.entity.Customer;
import com.mindtree.exception.DaoException;
import com.mindtree.exception.UtilityException;
import com.mindtree.utility.DBConnection;

public class CustomerDaoImpl implements CustomerDao {

	public Customer checkCustomer(byte id) throws DaoException {
		// TODO Auto-generated method stub
		//System.out.println(id);
		String query = "select * from customer where customerId=" + id;
		
		Customer customer = null;
		Connection connection=null;
		PreparedStatement statement=null;
		try {
		 
			connection = DBConnection.connectionToDB();
	
		
		
			statement = connection.prepareStatement(query);
			ResultSet resultSet = statement.executeQuery(query);
			if (resultSet.next()) {
				customer = new Customer(resultSet.getString(2),resultSet.getString(3),resultSet.getInt(4));
				//System.out.println(customer);
				return customer;
				//System.out.println(customer);
			}

			//statement.close();
			//connection.close();
		}catch (UtilityException e) {
			throw new DaoException("problem with connection",e);
		}
		catch (SQLException e) {
			//e.printStackTrace();
		
			throw new DaoException("problem with query",e);
		}
		finally{
			try{
				statement.close();
			connection.close();
			}catch(SQLException e){
				throw new DaoException("Resources not close properly",e);
			}
		}
		return null;

		
	}

}


