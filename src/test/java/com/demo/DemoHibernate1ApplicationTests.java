package com.demo;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.demo.entity.student;
import com.demo.repository.studentRepository;

@SpringBootTest
class DemoHibernate1ApplicationTests {
	@Autowired
	private studentRepository studentRepo;
	
	@Test
	void savestudent() {
		student s = new student();
		s.setName("kanha");
		s.setCity("BBSR");
		s.setCourse("testing");
		s.setFee(25000);
		
		studentRepo.save(s);
	}
	@Test
	void deletestudent() {
		studentRepo.deleteById(1);
	}
	@Test
	void findstudent() {
		Optional<student> student = studentRepo.findById(3);
		if (student.isPresent()) {
			student s = student.get();
			System.out.println(s.getName());
			System.out.println(s.getCity());
			System.out.println(s.getCourse());
			System.out.println(s.getFee());
		} else {
            System.out.println("resylt is not prasent");
		}
	}
	@Test
	void existstudent() {
		boolean val = studentRepo.existsById(2);
		System.out.println(val);
	}
	@Test
	void findAllstudent() {
		Iterable<student> student = studentRepo.findAll();
		for (student s : student) {
			System.out.println(s.getName());
			System.out.println(s.getCity());
			System.out.println(s.getCourse());
			System.out.println(s.getFee());
		}
	}
	 @Test
	void StudentUpdate() {
		Optional<student> findById = studentRepo.findById(2);
		student s = findById.get();
		s.setCourse("java");
		studentRepo.save(s);
	}
	 @Test
    void findByEmail() {
    	Optional<student> findByemail = studentRepo.findByemail("subham@gmail.com");
    	if (findByemail.isPresent()) {
    		student s = findByemail.get();
    		System.out.println(s.getName());
    		System.out.println(s.getCity());
    		System.out.println(s.getCourse());
    		System.out.println(s.getEmail());
    		System.out.println(s.getFee());
		} else {
           System.out.println("result not found");
		}
    }
	 @Test
	 void findBymobile() {
		 Optional<student> findBymobile = studentRepo.findBymobile(6371293623L);
			if (findBymobile.isPresent()) {
	    		student s = findBymobile.get();
	    		System.out.println(s.getName());
	    		System.out.println(s.getCity());
	    		System.out.println(s.getCourse());
	    		System.out.println(s.getEmail());
	    		System.out.println(s.getFee());
			} else {
	           System.out.println("result not found");
			}
	 }
	 @Test
	 void checkExists() {
		 boolean val = studentRepo.existsByemail("subham@gmail.com");
		 System.out.println(val);
	 }
	 @Test
	 void findstudentBycity() {
		 Iterable<student> findBycity = studentRepo.findBycity("Nandapur");
		 for (student s : findBycity) {
			 System.out.println(s.getName());
	    		System.out.println(s.getCity());
	    		System.out.println(s.getCourse());
	    		System.out.println(s.getEmail());
	    		System.out.println(s.getFee());
		}
	 }
}
