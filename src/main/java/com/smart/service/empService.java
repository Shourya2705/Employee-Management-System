package com.smart.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smart.entity.Employee;
import com.smart.repository.empRepository;

@Service
public class empService {

	@Autowired
  private empRepository repo;
	
  public void addEmp(Employee e) {
	  repo.save(e);
  }

public List<Employee> getAllEmp() {
	// TODO Auto-generated method stub
	return repo.findAll();
}

public Employee getEmpById(int id) {
	Optional<Employee> e= repo.findById(id);
	if(e.isPresent())
		return e.get();
 return null;
}
  public void deleteEmp(int id) {
	  repo.deleteById(id);
  }
}
