package com.Employee.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Employee.Entity.Employee;
import com.Employee.Repo.Emporepo;

@Service
public class EmpService {
	
	@Autowired
	public Emporepo emporepo;
	
	public void addemp(Employee e) {
		emporepo.save(e);
	}

	public List<Employee> getallemployee() {
		return emporepo.findAll();
	}
	
	public Employee getid(long id)
	{
		Optional<Employee> e= emporepo.findById(id);
		if(e.isPresent())
		{
			return e.get();
		}
		return null;
		
	}
	
	public void deletebyid(long id)
	{
		  emporepo.deleteById(id);
		
		
	}
}
