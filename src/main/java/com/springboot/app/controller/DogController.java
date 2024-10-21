package com.springboot.app.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
	
	@PostMapping("/getBreed")
    public ResponseEntity<Map<String, String>> getBreed(@RequestBody Dog answerRequest) {
        String breed = determineBreed(answerRequest.getAnswer());
        Map<String, String> response = new HashMap<>();
        response.put("breed", breed);
        return ResponseEntity.ok(response);
    }

	private String determineBreed(List<String> answers) {
	    if (answers == null || answers.isEmpty()) {
	        return "Unknown Breed";
	    }

	    // Count occurrences of each answer
	    Map<String, Integer> answerCount = new HashMap<>();
	    for (String answer : answers) {
	        answerCount.put(answer, answerCount.getOrDefault(answer, 0) + 1);
	    }

	    // Determine the most frequent answer
	    String mostFrequentAnswer = answers.get(0);
	    int maxCount = 0;
	    for (Map.Entry<String, Integer> entry : answerCount.entrySet()) {
	        if (entry.getValue() > maxCount) {
	            mostFrequentAnswer = entry.getKey();
	            maxCount = entry.getValue();
	        }
	    }

	    // Example mapping of the most frequent answer to breeds
	    Map<String, String> breedMap = new HashMap<>();
	    breedMap.put("A", "Pug");
	    breedMap.put("B", "Shih Tzu");
	    breedMap.put("C", "Chihuahua");
	    breedMap.put("D", "Golden Retriever");

	    // Fetch the corresponding breed from the map
	    return breedMap.getOrDefault(mostFrequentAnswer, "Unknown Breed");
	}

}
