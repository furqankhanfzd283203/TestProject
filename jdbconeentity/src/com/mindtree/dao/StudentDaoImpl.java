package com.mindtree.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Objects;

import com.mindtree.entity.Student;
import com.mindtree.exception.DaoException;
import com.mindtree.utility.DBConnection;

public class StudentDaoImpl implements StudentDao {

	@Override
	public void displayStudentFromDB(int id) throws DaoException {
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		connection = DBConnection.connectionToDB();
		if (!Objects.isNull(connection)) {
			try {
				String query = "select * from student where id=" + id;
				statement = connection.prepareStatement(query);
				resultSet = statement.executeQuery(query);
				while (resultSet.next()) {
					byte id1 = resultSet.getByte(1);
					String name = resultSet.getString(2);
					byte rollNumber = resultSet.getByte(3);
					System.out.println("id = " + id + " " + " name= " + name + " " + "rollNumber= " + rollNumber);

				}

			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				try {
					statement.close();
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}

		}

	}

	@Override
	public boolean insertStudentsIntoDB(Student[] students) throws DaoException {
		// TODO Auto-generated method stub
		boolean isInsert = false;
		int count = 0;
		PreparedStatement statement = null;
		for (int i = 0; i < students.length; i++) {
			Connection connection = DBConnection.connectionToDB();
			String query = "insert into student values(?,?,?)";
			byte id = students[i].getId();
			String name = students[i].getName();
			byte rollNumber = students[i].getRollNumber();

			try {

				statement = connection.prepareStatement(query);
				statement.setByte(1, id);
				statement.setString(2, name);
				statement.setByte(3, rollNumber);
				count = statement.executeUpdate();
				if (count >= 1)
					isInsert = true;

			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				try {
					statement.close();
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}

		}
		return isInsert;

	}

	@Override
	public boolean updateStudentIntoDB(int id1, String name1) throws DaoException {
		// TODO Auto-generated method stub
		boolean isUpdate = false;
		Connection connection = DBConnection.connectionToDB();
		PreparedStatement statement = null;
		if (!Objects.isNull(connection)) {
			try {
				String sqlQuery = "update student set name='"+name1+"' where id="+id1;
				statement = connection.prepareStatement(sqlQuery);
				int count = statement.executeUpdate(sqlQuery);
				if (count == 1)
					isUpdate = true;

			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				try {
					statement.close();
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}

		}

		return isUpdate;
	}

	@Override
	public boolean deleteStudentFromDB(int id2) throws DaoException {
		// TODO Auto-generated method stub
		boolean isDelete = false;
		Connection connection = DBConnection.connectionToDB();
		PreparedStatement statement = null;
		if (!Objects.isNull(connection)) {
			try {
				String sqlQuery = "delete from student where id=" + id2;
				statement = connection.prepareStatement(sqlQuery);
				int count = statement.executeUpdate(sqlQuery);
				if (count == 1)
					isDelete = true;

			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				try {
					statement.close();
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}

		}

		return isDelete;
	}

}
