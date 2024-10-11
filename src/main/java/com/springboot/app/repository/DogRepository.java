package com.springboot.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springboot.app.model.Dog;

@Repository
public interface DogRepository extends JpaRepository<Dog,Integer>{

}
