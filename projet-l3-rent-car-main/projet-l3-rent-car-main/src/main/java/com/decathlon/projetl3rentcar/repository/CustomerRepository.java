package com.decathlon.projetl3rentcar.repository;


import com.decathlon.projetl3rentcar.entity.Customer;
import com.decathlon.projetl3rentcar.entity.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {
}
