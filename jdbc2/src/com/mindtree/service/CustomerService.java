package com.mindtree.service;

import com.mindtree.entity.Customer;
import com.mindtree.exception.ServiceException;

public interface CustomerService {

	Customer checkCustomer(byte id) throws ServiceException;

}
