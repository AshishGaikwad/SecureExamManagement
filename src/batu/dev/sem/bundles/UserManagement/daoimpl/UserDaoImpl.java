package batu.dev.sem.bundles.UserManagement.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import batu.dev.sem.bundles.UserManagement.dao.UserDao;
import batu.dev.sem.bundles.UserManagement.entity.UserEntity;
import batu.dev.sem.utils.MySQLConnector;

public class UserDaoImpl implements UserDao {

	private Connection lConnection = null;
	private PreparedStatement lPreparedStatement = null;
	private ResultSet lResultSet = null;
	private String lQuery = "";

	@Override
	public int createUser(UserEntity pUserEntity) {
		try {

			if (getUser(pUserEntity.getEmail()) == null) {
				lQuery = "INSERT INTO `Users` " + "(" + "`id`, " + "`full_name`, " + "`dob`," + " `password`, "
						+ "`email`, " + "`mobile`, " + "`status`, " + "`c_by`, "
						+ "`c_at`, `u_by`, `u_at`) VALUES (NULL, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
				lConnection = MySQLConnector.getConnection();
				lPreparedStatement = lConnection.prepareStatement(lQuery);

				lPreparedStatement.setString(1, pUserEntity.getFullName());
				lPreparedStatement.setString(2, pUserEntity.getDateOfBirth());
				lPreparedStatement.setString(3, pUserEntity.getPassword());
				lPreparedStatement.setString(4, pUserEntity.getEmail());
				lPreparedStatement.setString(5, pUserEntity.getMobile());
				lPreparedStatement.setInt(6, pUserEntity.getStatus());

				lPreparedStatement.setLong(7, pUserEntity.getCreatedBy());
				lPreparedStatement.setString(8, pUserEntity.getCreatedAt());
				lPreparedStatement.setLong(9, pUserEntity.getUpdatedBy());
				lPreparedStatement.setString(10, pUserEntity.getUpdatedAt());
				int result = lPreparedStatement.executeUpdate();

				System.out.println(result + "= rESs");

				if (result != 0)
					return 1;
				else
					return 2;
			} else {
				return 0;
			}

		} catch (Exception e) {
			return 2;
		} finally {

		}
	}

	@Override
	public int updateUser(UserEntity pUserEntity) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteUser(UserEntity pUserEntity) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public UserEntity getUser(long pUserId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserEntity getUser(String pEmail) {
		try {
			UserEntity lUserEntity = new UserEntity();
			lConnection = MySQLConnector.getConnection();
			lQuery = "SELECT `id`,`full_name`,`dob`,`password`,`email`,`mobile`,`status`,`c_by`,`c_at`,`u_by`,`u_at` FROM `Users` where email = '"
					+ pEmail + "'";

			lResultSet = lConnection.createStatement().executeQuery(lQuery);

			if (lResultSet.next()) {
				lUserEntity.setUserId(lResultSet.getLong(1));
				lUserEntity.setFullName(lResultSet.getString(2));
				lUserEntity.setDateOfBirth(lResultSet.getString(3));
				lUserEntity.setPassword(lResultSet.getString(4));
				lUserEntity.setEmail(lResultSet.getString(5));
				lUserEntity.setMobile(lResultSet.getString(6));
				lUserEntity.setStatus(lResultSet.getInt(7));
				lUserEntity.setCreatedAt(lResultSet.getString(8));
				lUserEntity.setCreatedBy(lResultSet.getLong(9));
				lUserEntity.setUpdatedAt(lResultSet.getString(10));
				lUserEntity.setUpdatedBy(lResultSet.getInt(11));
				System.out.println(lUserEntity.toString());
				return lUserEntity;
			} else {
				System.out.println(null + "");
				return null;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return null;// TODO: handle exception
		}

	}

	@Override
	public int validateUser(String pEmail, String pPassword) {
		try {
			UserEntity lUserEntity = getUser(pEmail);

			if (lUserEntity == null)
				return 11;
			else {
				if (lUserEntity.getStatus() == 1) {
					if (lUserEntity.getEmail().equalsIgnoreCase(pEmail)
							&& lUserEntity.getPassword().equals(pPassword)) {
						return 9;
					} else {
						return 8;
					}
				} else {
					return 10;
				}
			}
		} catch (Exception e) {
			return 12;
		}

	}

	public static void main(String[] args) {

		UserDao lUserDao = new UserDaoImpl();

		UserEntity lUserEntity = new UserEntity();

		lUserEntity.setFullName("Ashish Gaikwad");
		lUserEntity.setMobile("8976834278");
		lUserEntity.setEmail("ashishgaikwad.6268@gmail.com");
		lUserEntity.setStatus(1);
		lUserEntity.setPassword("Ashish@1997");
		lUserEntity.setCreatedAt("");
		lUserEntity.setCreatedBy(0);
		lUserEntity.setUpdatedAt("");
		lUserEntity.setUpdatedBy(0);
		lUserEntity.setDateOfBirth("07/09/1997");

		System.out.println(lUserDao.createUser(lUserEntity));

	}

}
