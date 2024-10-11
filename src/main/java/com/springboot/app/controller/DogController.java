package com.springboot.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.app.model.Dog;
import com.springboot.app.service.DogService;

@RestController
@RequestMapping("/dog")
@CrossOrigin
public class DogController {
	
	@Autowired
	private DogService dogService;
	
	@PostMapping("/add")
	public String add(@RequestBody Dog dog) {
		dogService.saveDog(dog);
		return "New dog is added";
	}
	
	@GetMapping("/getAll")
	public List<Dog> getAllDog(){
		return dogService.getAllDogs();
	}
}
