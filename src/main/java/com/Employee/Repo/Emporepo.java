package com.Employee.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Employee.Entity.Employee;

@Repository
public interface Emporepo extends JpaRepository<Employee, Long>{
	
	

}
