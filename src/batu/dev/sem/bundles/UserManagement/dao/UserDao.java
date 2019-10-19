package batu.dev.sem.bundles.UserManagement.dao;

import batu.dev.sem.bundles.UserManagement.entity.UserEntity;

public interface UserDao 
{
	public boolean createUser(UserEntity pUserEntity);
	public boolean updateUser(UserEntity pUserEntity);
	public boolean deleteUser(UserEntity pUserEntity);
	
	public UserEntity getUser(long pUserId);
	public UserEntity getUser(String pUserName);
}
