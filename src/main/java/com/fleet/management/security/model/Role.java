package com.fleet.management.security.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fleet.management.models.Auditable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
	@Data
	
	public class Role extends Auditable<String> {
	   
		
		
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Integer id;

	    private String description;
	    private String details;
	    
	    
		public Integer getId() {
			// TODO Auto-generated method stub
			return null;
		}
		 public String getDescription() {
				return description;
			}
			public void setDescription(String description) {
				this.description = description;
			}
			public String getDetails() {
				return details;
			}
			public void setDetails(String details) {
				this.details = details;
			}
			public void setId(Integer id) {
				this.id = id;
			}
			public Role()
			{
				
			}
			public Role(Integer id, String description, String details) {
				super();
				this.id = id;
				this.description = description;
				this.details = details;
			}
	}

