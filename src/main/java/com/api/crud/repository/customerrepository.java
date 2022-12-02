package com.api.crud.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.api.crud.entity.Customers;

@Repository
public interface customerrepository extends JpaRepository<Customers, Long>{

}
