package com.springboot.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.app.model.Dog;
import com.springboot.app.repository.DogRepository;

@Service
public class DogServiceImpl implements DogService {

	@Autowired
	private DogRepository dogRepository;
	
	@Override
	public Dog saveDog(Dog dog) {
		return dogRepository.save(dog);
	}

	@Override
	public List<Dog> getAllDogs() {
		return dogRepository.findAll();
	}

}
