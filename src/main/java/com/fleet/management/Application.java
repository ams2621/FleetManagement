package com.fleet.management;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

/*
 * DASHBOARD
 * VEHICLES -- VEHICLE DATA MAINT MOVEMENTS HIRES
 * PARAMETERS -- VEHICLE MAKE, TYPES,MODELS, STATUS VALUES
 * PEOPLE -- EMPLOYEE, CLIENTS,SUPPLIERS,CONTACTS,USERS
 * HR SETTINGS-- JOB TITLES, EMPLOYEE TYPES
 * GLOBALS -- COUNTRIES STATES LOCATIONS
 * ACCOUNTS-- INVOICES ,STORE VALUES
 * 
 * 
 * COUNTRY -- ID,NAME
 * STATE -- ID,NAME,COUNTRY ID -- (@manytoOne)@joincolumn(name="countryid",insertable=false,updatable=false) -- PRIVATE COUNTRY country, Private int countryid
 * 
 */

@SpringBootApplication
@EnableJpaAuditing(auditorAwareRef="auditorAware")
public class Application {

	@Bean
	public AuditorAware<String> auditorAware() {
		return new SpringSecurityAuditorAware();
	}
	
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
