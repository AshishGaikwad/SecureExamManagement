package batu.dev.sem.bundles.UserManagement.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import batu.dev.sem.bundles.UserManagement.dao.OperationDao;
import batu.dev.sem.bundles.UserManagement.dao.RoleScreenMappingDao;
import batu.dev.sem.bundles.UserManagement.entity.MappingEntity;
import batu.dev.sem.utils.MySQLConnector;

public class RoleScreenMappingDaoImpl
		implements OperationDao<MappingEntity>, RoleScreenMappingDao {
	private Connection lConnection = null;
	private PreparedStatement lPreparedStatement = null;
	private ResultSet lResultSet = null;
	private String lQuery = "";
	@Override
	public int create(MappingEntity pEntity) {
		try {

			lQuery = "INSERT INTO `role_screen_mapping` (`id`,`r_id`,`s_id`,`rowstate`) VALUES (NULL, ?, ?, ?)";
			lConnection = MySQLConnector.getConnection();

			lConnection.setAutoCommit(false);
			lPreparedStatement = lConnection.prepareStatement(lQuery);

			lPreparedStatement.setLong(1, pEntity.getRoleId());
			lPreparedStatement.setLong(2, pEntity.getUserId());
			lPreparedStatement.setLong(3, pEntity.getRowstate());

			
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
	public int update(MappingEntity pEntity) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(MappingEntity pEntity) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public MappingEntity get(long pId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MappingEntity get(String pName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<MappingEntity> get(String... p) {
		// TODO Auto-generated method stub
		return null;
	}
public static void main(String[] args) {
	OperationDao<MappingEntity> lRolesMapping = new RoleScreenMappingDaoImpl();
	
	MappingEntity lScreenEntity = new MappingEntity();
	lScreenEntity.setRoleId(1);
	lScreenEntity.setUserId(2);
	lScreenEntity.setRowstate(1);
	
	System.out.println("User Screen Map Created == "+lRolesMapping.create(lScreenEntity));
}
}
