package com.fleet.management.repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fleet.management.models.Client;
import com.fleet.management.models.JobTitle;
@Repository
public interface JobTitleRepository extends JpaRepository<JobTitle,Integer>{

}
