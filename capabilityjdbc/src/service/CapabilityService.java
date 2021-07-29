package service;

import entity.Capability;
import exception.ServiceException;

public interface CapabilityService {
	public Capability[] insertCapabilityIntoDB(Capability[] capability) throws ServiceException;

	public Capability checkCapability(int id) throws ServiceException;
}
