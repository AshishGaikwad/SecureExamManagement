package batu.dev.sem.bundles.UserManagement.dao;

import batu.dev.sem.bundles.UserManagement.entity.UserEntity;

public interface UserDao 
{
	public int createUser(UserEntity pUserEntity);
	public int updateUser(UserEntity pUserEntity);
	public int deleteUser(UserEntity pUserEntity);
	
	public UserEntity getUser(long pUserId);
	public UserEntity getUser(String pUserName);
}
