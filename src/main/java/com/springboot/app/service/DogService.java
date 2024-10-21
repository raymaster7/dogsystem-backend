package com.springboot.app.service;

import java.util.List;

import com.springboot.app.model.Dog;

public interface DogService {
	
	public Dog saveDog(Dog dog);
	public List<Dog> getAllDogs();
	public String getBreed(List<String> answers);
}
