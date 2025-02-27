package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Receipe;

@Repository
public interface ReceipeRepository extends JpaRepository<Receipe, Long>{

}