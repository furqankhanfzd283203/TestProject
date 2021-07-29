package dao;

import entity.Capability;
import exception.DaoException;

public interface CapabilityDao {
	

	public Capability[] insertCapabilityIntoDB(Capability[] capability) throws DaoException;
	public Capability checkCapabilityInDB(int id) throws DaoException;
}
