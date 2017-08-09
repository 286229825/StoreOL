package service;

import java.util.Set;

import entity.User;

public interface RoleService {
	
	public Set<String> getRoles(String username)throws Exception;

	public Set<String> getPermissons(String name)throws Exception;
	
	public User getUser(String username)throws Exception;
}
