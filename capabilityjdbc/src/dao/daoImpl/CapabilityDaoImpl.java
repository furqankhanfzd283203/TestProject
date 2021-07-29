package dao.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import dao.CapabilityDao;
import entity.Capability;
import exception.DaoException;
import utility.DBConnection;

public class CapabilityDaoImpl implements CapabilityDao {

	@Override
	public Capability[] insertCapabilityIntoDB(Capability[] capability) throws DaoException {
		for (int i = 0; i < capability.length; i++) {
			String query = "insert into capability values(?,?,?)";
			Connection connection = DBConnection.connectionToDB();
			PreparedStatement statement=null;
			try {
				 statement = connection.prepareStatement(query);
				int id = capability[i].getId();
				String name = capability[i].getName();
				String status = capability[i].getStatus();
				statement.setInt(1, id);
				statement.setString(2, name);
				statement.setString(3, status);
				int count = statement.executeUpdate();
				if (count == 1) {
					System.out.println(count + " row updated");

				}
				statement.close();
				connection.close();
			} catch (SQLException e) {
				System.out.println(e);
			}
			finally{
				try{
					statement.close();
				connection.close();
				}catch(SQLException e){
					e.printStackTrace();
				}
			}

		}
		return capability;
	}

	@Override
	public Capability checkCapabilityInDB(int id) throws DaoException {
		String query = "select * from capability where id=" + id;
		Capability capability = null;
		Connection connection = DBConnection.connectionToDB();
		PreparedStatement statement=null;
		try {
			statement = connection.prepareStatement(query);
			ResultSet resultSet = statement.executeQuery(query);
			if (resultSet.next() == true) {
				capability = new Capability(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3));
				return capability;
			}

			statement.close();
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally{
			try{
				statement.close();
			connection.close();
			}catch(SQLException e){
				e.printStackTrace();
			}
		}
		return null;

	}

}
