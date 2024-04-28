package com.example.demo.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.Complain;
import com.example.demo.repository.ComplainRepository;

@CrossOrigin(origins = "http://localhost:3000/")
@RestController
@RequestMapping("/api/v1/")
public class ComplainController {

	@Autowired
	private ComplainRepository complainRepository;
	
	//get All complain
	@GetMapping("/complain")
	public List<Complain> getAllcomplain(){
		return complainRepository.findAll();
	}
	
	//create complain REST API
	@PostMapping("/complain")
	public Complain createComplain(@RequestBody Complain complain) {
		return complainRepository.save(complain);
	}
	
	//Get Complain by ID
	@GetMapping("/complain/{id}")
	public ResponseEntity<Complain> getComplainById(@PathVariable Long id) {
		Complain  complain= complainRepository.findById(id)
				.orElseThrow(()->new ResourceNotFoundException("Complain not exit with id: "+id));
		return ResponseEntity.ok(complain);
	}
	
	//Update Complain Rest API
	@PutMapping("/complain/{id}")
	public ResponseEntity<Complain> updateComplain(@PathVariable Long id,@RequestBody Complain complainDetails) {
		Complain  complain= complainRepository.findById(id)
				.orElseThrow(()->new ResourceNotFoundException("Complain not exit with id: "+id));
		complain.setName(complainDetails.getName());
		complain.setEmail_id(complainDetails.getEmail_id());
		complain.setReported_issue(complainDetails.getReported_issue());
		complain.setStatus(complainDetails.getStatus());
		
		Complain updatedComplain = complainRepository.save(complain);
		return ResponseEntity.ok(updatedComplain);
	}
	
	//delete Complain rest API
	@DeleteMapping("/complain/{id}")
	public ResponseEntity<Map<String,Boolean>> deleteComplain(@PathVariable Long id) {
		Complain  complain= complainRepository.findById(id)
				.orElseThrow(()->new ResourceNotFoundException("Complain not exit with id: "+id));
		
		
		complainRepository.delete(complain);
		Map<String,Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}
}