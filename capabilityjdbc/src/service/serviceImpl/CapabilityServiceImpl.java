package service.serviceImpl;

import dao.CapabilityDao;
import dao.daoImpl.CapabilityDaoImpl;
import entity.Capability;
import exception.ServiceException;
import service.CapabilityService;

public class CapabilityServiceImpl implements CapabilityService {
	CapabilityDao capabilityDao=new CapabilityDaoImpl();

	@Override
	public Capability[] insertCapabilityIntoDB(Capability[] capability) throws ServiceException {
		Capability[] capability1=capabilityDao.insertCapabilityIntoDB(capability);
		return capability1;
	}

	@Override
	public Capability checkCapability(int id) throws ServiceException {
		
		return capabilityDao.checkCapabilityInDB(id);
	}

}
