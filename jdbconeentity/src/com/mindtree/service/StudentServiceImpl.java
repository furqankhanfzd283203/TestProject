package com.mindtree.service;

import com.mindtree.dao.StudentDao;
import com.mindtree.dao.StudentDaoImpl;
import com.mindtree.entity.Student;
import com.mindtree.exception.DaoException;
import com.mindtree.exception.ServiceException;

public class StudentServiceImpl implements StudentService {
	StudentDao studentDao=new StudentDaoImpl();

	@Override
	public boolean deleteStudentFromDB(int id2) throws ServiceException {
		// TODO Auto-generated method stub
		boolean isDelete=studentDao.deleteStudentFromDB(id2);
		return isDelete;
	}

	@Override
	public boolean updateStudentIntoDB(int id1, String name) throws ServiceException {
		// TODO Auto-generated method stub
		boolean isUpdate=studentDao.updateStudentIntoDB(id1,name);
		return isUpdate;
	}

	@Override
	public void displayStudentFromDB(int id) throws ServiceException {
		// TODO Auto-generated method stub
		studentDao.displayStudentFromDB(id);
		
	}

	@Override
	public boolean insertStudentsIntoDB(Student[] students) throws ServiceException {
		// TODO Auto-generated method stub
		boolean isInsert=studentDao.insertStudentsIntoDB(students);
		return isInsert;
	}

}
