package com.mindtree.dao;

import com.mindtree.entity.Student;
import com.mindtree.exception.DaoException;

public interface StudentDao {

	
	void displayStudentFromDB(int id) throws DaoException;

	boolean insertStudentsIntoDB(Student[] students) throws DaoException;

	boolean updateStudentIntoDB(int id1, String name) throws DaoException;

	boolean deleteStudentFromDB(int id2) throws DaoException;

	
}
