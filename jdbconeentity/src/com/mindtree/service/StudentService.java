package com.mindtree.service;

import com.mindtree.entity.Student;
import com.mindtree.exception.ServiceException;

public interface StudentService {

	boolean deleteStudentFromDB(int id2) throws ServiceException;

	boolean updateStudentIntoDB(int id1, String name) throws ServiceException;

	void displayStudentFromDB(int id) throws ServiceException;

	boolean insertStudentsIntoDB(Student[] students) throws ServiceException;

}
