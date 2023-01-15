package com.fleet.management.security.service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fleet.management.models.Country;
import com.fleet.management.models.User;
import com.fleet.management.repositories.UserRepository;
import com.fleet.management.security.model.Role;
import com.fleet.management.security.repositories.RoleRepository;

@Service
public class RoleService {

	@Autowired
	private RoleRepository roleRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	public List<Role> getRoles(){
		return roleRepository.findAll();
	}	
	
	//Get By Id
	public Role findById(int id) {
		return roleRepository.findById(id).orElse(null);
	}	
	
	//Delete 
	public void delete(Integer id) {
		roleRepository.deleteById(id);
	}
	
	//Update Role
	public void save( Role role) {
		roleRepository.save(role);
	}
	
	//Assign Role to User
	public void assignUserRole(Integer userId, Integer roleId){
	    User user  = userRepository.findById(userId).orElse(null);
	    Role role = roleRepository.findById(roleId).orElse(null);
	   Set<Role> userRoles = user.getRoles();
	   userRoles.add(role);
	   user.setRoles(userRoles);
	   userRepository.save(user);
	}
	
	//Unassign Role to User
	public void unassignUserRole(Integer userId, Integer roleId){
	    User user  = userRepository.findById(userId).orElse(null);
	    user.getRoles().removeIf(x -> x.getId()==roleId);
	    userRepository.save(user);
	}
	
	public Set<Role> getUserRoles(User user) {
		// TODO Auto-generated method stub
		return user.getRoles() ;
	}

	public Set<Role> getUserNotRoles(User user) {
		return roleRepository.getUserNotRoles(user.getId());
		// TODO Auto-generated method stub
		
	}
}
