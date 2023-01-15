package com.fleet.management.security.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fleet.management.models.User;
import com.fleet.management.security.model.Role;
import com.fleet.management.security.service.RoleService;
import com.fleet.management.services.UserService;

@Controller
public class RoleController {

	@Autowired 

	private RoleService roleService;
	@Autowired
	
	private UserService userService;
		
		
		@GetMapping("/roles")
		public String findAll(Model model){		
			model.addAttribute("roles", roleService.getRoles());
			return "role";
		}	
		
		@RequestMapping("/roles/findById") 
		@ResponseBody
		public Optional<Role> findById(Integer id)
		{
			return Optional.ofNullable(roleService.findById(id));
		}
		
		
		@PostMapping(value="/roles/addNew")
		public String addNew(Role role) {
			roleService.save(role);
			return "redirect:/roles";
		}	
		
		@RequestMapping(value="/roles/update", method = {RequestMethod.PUT, RequestMethod.GET})
		public String update(Role role) {
			roleService.save(role);
			return "redirect:/roles";
		}
		
		@RequestMapping(value="/roles/delete", method = {RequestMethod.DELETE, RequestMethod.GET})	
		public String delete(Integer id) {
			roleService.delete(id);
			return "redirect:/roles";
		}
		@GetMapping("/user/Edit/{id}")
		public String editUser(@PathVariable Integer id, Model model){
		    User user = userService.findById(id);
		    model.addAttribute("user", user);
		    model.addAttribute("userRoles", roleService.getUserRoles(user));
		    model.addAttribute("userNotRoles", roleService.getUserNotRoles(user));
		    return "/userEdit";
		}
		@RequestMapping("/role/assign/{userId}/{roleId}")
		public String assignRole(@PathVariable Integer userId, 
		                         @PathVariable Integer roleId){
		    roleService.assignUserRole(userId, roleId);
		    return "redirect:/security/user/Edit/"+userId;
		}
		@RequestMapping("/role/unassign/{userId}/{roleId}")
		public String unassignRole(@PathVariable Integer userId,
		                           @PathVariable Integer roleId){
		    roleService.unassignUserRole(userId, roleId);
		    return "redirect:/security/user/Edit/"+userId;
		}
}
