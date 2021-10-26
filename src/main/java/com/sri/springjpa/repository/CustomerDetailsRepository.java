package com.sri.springjpa.repository;

import com.sri.springjpa.entity.CustomerDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerDetailsRepository extends JpaRepository<CustomerDetails, Long> {

    List<CustomerDetails> findByName(String name);

}
