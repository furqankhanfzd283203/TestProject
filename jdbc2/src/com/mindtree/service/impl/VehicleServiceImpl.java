package com.mindtree.service.impl;

import java.util.Set;

import com.mindtree.dao.VehicleDao;
import com.mindtree.dao.impl.VehicleDaoImpl;
import com.mindtree.entity.Vehicle;
import com.mindtree.exception.DaoException;
import com.mindtree.exception.ServiceException;
import com.mindtree.service.VehicleService;

public class VehicleServiceImpl implements VehicleService {
	VehicleDao vehicleDao=new VehicleDaoImpl();

	@Override
	public Set<Vehicle> getAllVehicle() throws ServiceException {
		// TODO Auto-generated method stub
		try{
		return vehicleDao.getAllVehicle();
		}catch(DaoException e){
			throw new ServiceException("erroe occure",e);
		}
	}

	@Override
	public Set<Vehicle> getAllCustomersWithVehicle() throws ServiceException {
		// TODO Auto-generated method stub
		try{
		return vehicleDao.getAllCustomersWithVehicle();
		}catch(DaoException e){
			throw new ServiceException("error occure",e);
		}
	}

	@Override
	public Set<Vehicle> insertVehicleIntoDB(Set<Vehicle> vehicleSet, byte id) throws ServiceException {
		// TODO Auto-generated method stub
		try{
		return vehicleDao.insertVehicleIntoDB(vehicleSet,id);
		}catch(DaoException e){
			//e.printStackTrace();
			throw new ServiceException("erroe occure",e);
		}
	}

}
