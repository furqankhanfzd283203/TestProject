package dao;

import java.util.List;

import entity.Ko;
import exception.DaoException;

public interface KoDao {
	public Ko[] insertKoIntoDB(Ko[] ko) throws DaoException;

	public List<Ko> getAllKoByCapabilityNameFromDB(String name) throws DaoException;

	public List<Ko> getAllKoByCapabilityStatusFromDB(String status) throws DaoException;

	public void getSortedKoByNameFromDB() throws DaoException;
}
