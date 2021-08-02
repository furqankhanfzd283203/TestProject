package com.mindtree.dao;

import com.mindtree.entity.Customer;
import com.mindtree.exception.DaoException;

public interface CustomerDao {

	

	Customer checkCustomer(byte id) throws DaoException;

}
