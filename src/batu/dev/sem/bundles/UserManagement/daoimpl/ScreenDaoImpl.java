package batu.dev.sem.bundles.UserManagement.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import batu.dev.sem.bundles.UserManagement.dao.OperationDao;
import batu.dev.sem.bundles.UserManagement.dao.ScreenDao;
import batu.dev.sem.bundles.UserManagement.entity.RoleEntity;
import batu.dev.sem.bundles.UserManagement.entity.ScreenEntity;
import batu.dev.sem.utils.MySQLConnector;

public class ScreenDaoImpl implements ScreenDao,OperationDao<ScreenEntity> {
	private Connection lConnection = null;
	private PreparedStatement lPreparedStatement = null;
	private ResultSet lResultSet = null;
	private String lQuery = "";
	@Override
	public int create(ScreenEntity pEntity) {
		try {

			if(get(pEntity.getScreenName()) == null)
			{
			lQuery = "INSERT INTO `screens` (`screen_id`, `screen_name`, `screen_url`, `screen_parent`, `screen_menu_level`, `rowstate`) VALUES (NULL, ?, ?, ?, ?, ?)";
			lConnection = MySQLConnector.getConnection();

			lConnection.setAutoCommit(false);
			lPreparedStatement = lConnection.prepareStatement(lQuery);

			lPreparedStatement.setString(1, pEntity.getScreenName());
			lPreparedStatement.setString(2, pEntity.getScreenUrl());
			lPreparedStatement.setLong(3, pEntity.getScreenParentId());
			lPreparedStatement.setString(4, pEntity.getScreenMenuLevel());
			lPreparedStatement.setLong(5, pEntity.getRowstate());
			
			int result = lPreparedStatement.executeUpdate();
			lConnection.commit();
			// System.out.println(result + "= rESs");

			lConnection = null;
			lPreparedStatement = null;
			lResultSet = null;
			lQuery = "";
			if (result != 0)
				return 1;
			else
				return 2;
		
			}else
			{
				return 3;
			}
	} catch (Exception e) {
		try {
			lConnection.rollback();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		lConnection = null;
		lPreparedStatement = null;
		lResultSet = null;
		lQuery = "";

		return 2;
	} finally {
		lConnection = null;
		lPreparedStatement = null;
		lResultSet = null;
		lQuery = "";
	}
	}

	@Override
	public int update(ScreenEntity pEntity) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(ScreenEntity pEntity) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ScreenEntity get(long pId) {
		try {
			ScreenEntity lEntity = new ScreenEntity();
			lConnection = MySQLConnector.getConnection();
			lQuery = "SELECT `screen_id`, `screen_name`, `screen_url`, `screen_parent`, `screen_menu_level`, `rowstate` FROM `screens` where screen_id = '"
					+ pId + "'";

			lResultSet = lConnection.createStatement().executeQuery(lQuery);

			if (lResultSet.next()) {
				lEntity.setScreenId(lResultSet.getLong(1));
				lEntity.setScreenName(lResultSet.getString(2));
				lEntity.setScreenUrl(lResultSet.getString(3));
				lEntity.setScreenParentId(lResultSet.getLong(4));
				lEntity.setScreenMenuLevel(String.valueOf(lResultSet.getInt(5)));
				lEntity.setRowstate(lResultSet.getInt(6));
				
//				System.out.println(lEntity.toString());
				
				lConnection = null;
				lPreparedStatement = null;
				lResultSet = null;
				return lEntity;
			} else {
				lConnection = null;
				lPreparedStatement = null;
				lResultSet = null;
				return null;
			}
		} catch (Exception e) {
			e.printStackTrace();
			lConnection = null;
			lPreparedStatement = null;
			lResultSet = null;
			return null;// TODO: handle exception
		}finally {
			lConnection = null;
			lPreparedStatement = null;
			lResultSet = null;
		}
	}

	@Override
	public ScreenEntity get(String pName) {
		try {
			ScreenEntity lEntity = new ScreenEntity();
			lConnection = MySQLConnector.getConnection();
			lQuery = "SELECT `screen_id`, `screen_name`, `screen_url`, `screen_parent`, `screen_menu_level`, `rowstate` FROM `screens` where screen_name = '"
					+ pName + "'";

			lResultSet = lConnection.createStatement().executeQuery(lQuery);

			if (lResultSet.next()) {
				lEntity.setScreenId(lResultSet.getLong(1));
				lEntity.setScreenName(lResultSet.getString(2));
				lEntity.setScreenUrl(lResultSet.getString(3));
				lEntity.setScreenParentId(lResultSet.getLong(4));
				lEntity.setScreenMenuLevel(String.valueOf(lResultSet.getInt(5)));
				lEntity.setRowstate(lResultSet.getInt(6));
				
//				System.out.println(lEntity.toString());
				
				lConnection = null;
				lPreparedStatement = null;
				lResultSet = null;
				return lEntity;
			} else {
				lConnection = null;
				lPreparedStatement = null;
				lResultSet = null;
				return null;
			}
		} catch (Exception e) {
			e.printStackTrace();
			lConnection = null;
			lPreparedStatement = null;
			lResultSet = null;
			return null;// TODO: handle exception
		}finally {
			lConnection = null;
			lPreparedStatement = null;
			lResultSet = null;
		}
	}

	@Override
	public List<ScreenEntity> get(String... p) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public static void main(String[] args) {
		OperationDao<ScreenEntity> lDao = new ScreenDaoImpl();
		ScreenEntity lScreenEntity = new ScreenEntity();
		
		lScreenEntity.setScreenName("Create User");
		lScreenEntity.setScreenParentId(1);
		lScreenEntity.setScreenUrl("impl/CreateUser.jsp");
		lScreenEntity.setScreenMenuLevel("0");
		lScreenEntity.setRowstate(1);

		
		System.out.println("Result  == "+lDao.create(lScreenEntity));
		System.out.println("Result 2 == "+lDao.get("User Managemen"));
		
	}

}
