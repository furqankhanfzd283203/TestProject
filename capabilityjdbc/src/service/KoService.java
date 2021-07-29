package service;

import java.util.List;

import entity.Ko;
import exception.ServiceException;

public interface KoService {
	public Ko[] insertKoIntoDB(Ko[] ko) throws ServiceException;
	public List<Ko> getAllKoByCapabilityNameFromDB(String name) throws ServiceException;
	public List<Ko> getAllKoByCapabilityStatusFromDB(String status) throws ServiceException;
	public void getSortedKoByNameFromDB() throws ServiceException;
}
