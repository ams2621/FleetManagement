package com.fleet.management.repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fleet.management.models.Client;

@Repository
public interface ClientRepository extends JpaRepository<Client,Integer>{

}
