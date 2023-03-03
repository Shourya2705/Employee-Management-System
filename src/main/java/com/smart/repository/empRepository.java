package com.smart.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.smart.entity.Employee;

@Repository
public interface empRepository extends JpaRepository<Employee,Integer> {

}
