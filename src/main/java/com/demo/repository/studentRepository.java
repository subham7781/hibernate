package com.demo.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.demo.entity.student;

public interface studentRepository extends CrudRepository<student, Integer>{
	Optional<student> findByemail(String email);
	Optional<student> findBymobile(long mobile);
	boolean existsByemail(String email);
	Iterable<student> findBycity(String city);
	

}
