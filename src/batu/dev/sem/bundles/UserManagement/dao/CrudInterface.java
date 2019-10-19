package batu.dev.sem.bundles.UserManagement.dao;

import batu.dev.sem.bundles.UserManagement.entity.UserEntity;

public interface CrudInterface<C> {
	public boolean create(UserEntity pUserEntity);
	public boolean update(UserEntity pUserEntity);
	public boolean delete(UserEntity pUserEntity);
	public UserEntity get(long pId);
	public UserEntity get(String pName);
}
