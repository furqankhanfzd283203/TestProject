package com.mindtree.service.impl;

import com.mindtree.dao.CustomerDao;
import com.mindtree.dao.impl.CustomerDaoImpl;
import com.mindtree.entity.Customer;
import com.mindtree.exception.DaoException;
import com.mindtree.exception.ServiceException;
import com.mindtree.exception.service.AgeException;
import com.mindtree.exception.service.NoSuchCustomerException;
import com.mindtree.service.CustomerService;

public class CustomerServiceImpl implements CustomerService {
	CustomerDao customerDao=new CustomerDaoImpl();

	@Override
	public Customer checkCustomer(byte id) throws ServiceException {
		// TODO Auto-generated method stub
		try{
		Customer customer = customerDao.checkCustomer(id);
		//System.out.println(customer);
		if (customer == null) {
			throw new NoSuchCustomerException("Given customer id is not present");
		}
		else if(customer.getAge()<20){
			throw new AgeException("given customer age is less than 20 years");
		}
			else {
			return customer;
		}
	}catch(DaoException e){
		//e.printStackTrace();
		throw new ServiceException("error occure",e);
	}

}
}
