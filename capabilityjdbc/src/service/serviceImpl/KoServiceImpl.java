package service.serviceImpl;

import java.util.List;

import dao.KoDao;
import dao.daoImpl.KoDaoImpl;
import entity.Ko;
import exception.ServiceException;
import service.KoService;

public class KoServiceImpl implements KoService {
	KoDao koDao = new KoDaoImpl();

	@Override
	public Ko[] insertKoIntoDB(Ko[] ko) throws ServiceException {
		Ko[] ko1 = koDao.insertKoIntoDB(ko);
		return ko1;
	}

	@Override
	public List<Ko> getAllKoByCapabilityNameFromDB(String name) throws ServiceException {

		List<Ko> koByCapabilityName = koDao.getAllKoByCapabilityNameFromDB(name);
		return koByCapabilityName;
	}

	@Override
	public List<Ko> getAllKoByCapabilityStatusFromDB(String status) throws ServiceException {
		List<Ko> koByCapabilityStatus = koDao.getAllKoByCapabilityStatusFromDB(status);
		return koByCapabilityStatus;
	}

	@Override
	public void getSortedKoByNameFromDB() throws ServiceException {
		koDao.getSortedKoByNameFromDB();

	}

}
