package com.sparrow.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sparrow.dto.Response;
import com.sparrow.service.DeactivationService;

@RestController
@CrossOrigin
@RequestMapping("/sparrow")
public class DeactivationController {
	@Autowired
	private DeactivationService deactivationService;
	
	@GetMapping("/deactivate/institute/{id}")
	public ResponseEntity<?> deactivateInstitute(@PathVariable Long id){
		Response<?> response=deactivationService.deactivateInstitute(id);
		return new ResponseEntity<>(response,HttpStatus.OK);
	}
	
	@GetMapping("/deactivate/academicYear/{id}")
	public ResponseEntity<?> deactivateAcademicYear(@PathVariable Long id){
		Response<?> response=deactivationService.deactivatAcademicYear(id);
		return new ResponseEntity<>(response,HttpStatus.OK);
	}


}
