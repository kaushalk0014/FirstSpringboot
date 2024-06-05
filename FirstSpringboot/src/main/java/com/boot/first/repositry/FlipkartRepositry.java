package com.boot.first.repositry;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.boot.first.domain.Customer;

@Repository
public interface FlipkartRepositry extends JpaRepository<Customer, Integer> {
	
	 public static void testMethod() {
		 System.out.println("--------------------");
	 }
}
