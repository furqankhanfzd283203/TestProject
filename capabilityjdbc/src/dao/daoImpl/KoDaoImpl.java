package dao.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import dao.KoDao;
import entity.Capability;
import entity.Ko;
import exception.DaoException;
import utility.DBConnection;

public class KoDaoImpl implements KoDao {
	CapabilityDaoImpl capabilityDaoImpl = new CapabilityDaoImpl();

	@Override
	public Ko[] insertKoIntoDB(Ko[] ko) throws DaoException {
		for (int i = 0; i < ko.length; i++) {
			String query = "insert into ko values(?,?,?,?,?)";
			Connection connection = DBConnection.connectionToDB();
			try {
				PreparedStatement statement = connection.prepareStatement(query);
				int id = ko[i].getId();
				String name = ko[i].getName();
				String koType = ko[i].getKoType();
				String description = ko[i].getDesciption();
				int id1 = ko[i].getCapability().getId();
				statement.setInt(1, id);
				statement.setString(2, name);
				statement.setString(3, koType);
				statement.setString(4, description);
				statement.setInt(5, id1);
				int count = statement.executeUpdate();
				if (count == 1) {
					System.out.println(count + " row updated");

				}
				statement.close();
				connection.close();
			} catch (SQLException e) {
				System.out.println(e);
			}
		}

		return ko;
	}

	@Override
	public List<Ko> getAllKoByCapabilityNameFromDB(String name) throws DaoException {
		List<Ko> kos = new ArrayList<Ko>();
		String query = "select k.*,c.* from capability c,ko k where c.id=k.cap_id and c.name='" + name + "'";

		Connection connection = DBConnection.connectionToDB();
		try {

			PreparedStatement statement = connection.prepareStatement(query);

			ResultSet resultSet = statement.executeQuery(query);
			while (resultSet.next()) {
				int id = resultSet.getInt(1);
				String name1 = resultSet.getString(2);
				String koType = resultSet.getString(3);
				String description = resultSet.getString(4);
				int cap_id = resultSet.getInt(6);
				String cap_name = resultSet.getString(7);
				String cap_status = resultSet.getString(8);
				Capability cap = new Capability(cap_id, cap_name, cap_status);
				Ko ko = new Ko(id, name1, koType, description, cap);

				kos.add(ko);
			}

			statement.close();
			connection.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return kos;

	}

	@Override
	public List<Ko> getAllKoByCapabilityStatusFromDB(String status) throws DaoException {
		List<Ko> kos = new ArrayList<Ko>();
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;
		connection = DBConnection.connectionToDB();
		if (!Objects.isNull(connection)) {
			try {
				String query = "select k.*,c.* from capability c,ko k where c.id=k.cap_id and c.status='" + status
						+ "'";
				statement = connection.createStatement();
				resultSet = statement.executeQuery(query);
				while (resultSet.next()) {
					int id = resultSet.getInt(1);
					String name1 = resultSet.getString(2);
					String koType = resultSet.getString(3);
					String description = resultSet.getString(4);
					int cap_id = resultSet.getInt(6);
					String cap_name = resultSet.getString(7);
					String cap_status = resultSet.getString(8);
					Capability cap = new Capability(cap_id, cap_name, cap_status);
					Ko ko = new Ko(id, name1, koType, description, cap);
					kos.add(ko);
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
		return kos;

	}

	@Override
	public void getSortedKoByNameFromDB() throws DaoException {
		// List<Ko> kos = new ArrayList<Ko>();
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		connection = DBConnection.connectionToDB();
		if (!Objects.isNull(connection)) {
			try {
				String query = "select * from ko order by name";
				statement = connection.prepareStatement(query);
				resultSet = statement.executeQuery(query);
				while (resultSet.next()) {
					int id = resultSet.getInt(1);
					String name1 = resultSet.getString(2);
					String koType = resultSet.getString(3);
					String description = resultSet.getString(4);
					System.out.println("id = " + id + " " + " name= " + name1 + " " + "kotype= " + koType + " "
							+ "description= " + description);

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

}
