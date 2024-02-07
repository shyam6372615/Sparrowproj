package com.sparrow.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sparrow.dto.Response;
import com.sparrow.entity.AcademicBatchYearEntity;
import com.sparrow.entity.AcademicYearEntity;
import com.sparrow.entity.InstituteEntity;
import com.sparrow.entity.InstituteTypeEntity;
import com.sparrow.service.DeactivationService;
import com.sparrow.service.MasterService;
import com.sparrow.service.ValidationService;
@RestController
@CrossOrigin
@RequestMapping("/sparrow")
public class MasterController {
	@Autowired
	private MasterService masterService;
	@Autowired
	private ValidationService validationService;
	@Autowired
	private DeactivationService deactivationService;
	
	
	@PostMapping("/addInstitute")
	public ResponseEntity<?> addInstitute(@RequestBody InstituteEntity instEntity){
		Response<?> validationResponse = validationService.validateForInstituteAdd(instEntity);
		if (validationResponse.getResponseCode() == HttpStatus.OK.value()) {
			Response<?> response = masterService.addInstitute(instEntity);
			return new ResponseEntity<>(response, HttpStatus.valueOf(response.getResponseCode()));
		} else {
			return new ResponseEntity<>(validationResponse, HttpStatus.valueOf(validationResponse.getResponseCode()));
		}
	}
	@GetMapping("/getAllInstitute")
	public ResponseEntity<?> getAllInstitute(){
		List<InstituteEntity> list= masterService.getAllInstitute();
		return new ResponseEntity<>(list, HttpStatus.OK);
		
	}

	@GetMapping("/getInstituteById/{id}")
	public ResponseEntity<?> getInstituteById(@PathVariable("id") long instituteId) {
		Optional<?> instituteData = masterService.getInstituteById(instituteId);
		if (instituteData.isPresent()) {
			return new ResponseEntity<>(instituteData.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	@PutMapping("/updateInstitute")
	public ResponseEntity<?> updateInstitute(@RequestBody InstituteEntity instEntity) {
		InstituteEntity instituteEntityData = masterService.updateInstitute(instEntity);
		if (instituteEntityData != null) {
			return new ResponseEntity<>(instituteEntityData, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		
	}
	@GetMapping("/getAllInstituteType")
	public ResponseEntity<?> getAllInstituteType(){
		List<InstituteTypeEntity> list= masterService.getAllInstituteType();
		return new ResponseEntity<>(list, HttpStatus.OK);
	
}
	
	@PostMapping("/addAcademicYear")
	public ResponseEntity<?> addAcademicYear(@RequestBody AcademicYearEntity academicYearEntity){
		Response<?> validationResponse = validationService.validateForAcademicYearAdd(academicYearEntity);
		if (validationResponse.getResponseCode() == HttpStatus.OK.value()) {
			Response<?> response = masterService.addAcademicYear(academicYearEntity);
			return new ResponseEntity<>(response, HttpStatus.valueOf(response.getResponseCode()));
		} else {
			return new ResponseEntity<>(validationResponse, HttpStatus.valueOf(validationResponse.getResponseCode()));
		}
	}
	@GetMapping("/getAllAcademicYear")
	public ResponseEntity<?> getAllAcademicYear(){
		List<AcademicYearEntity> list= masterService.getAllAcademicYear();
		return new ResponseEntity<>(list, HttpStatus.OK);
}

@GetMapping("/getAcademicYearById/{id}")
public ResponseEntity<?> getAcademicYearById(@PathVariable("id") long academicId) {
	Optional<?> academicYearData = masterService.getAcademicYearById(academicId);
	if (academicYearData.isPresent()) {
		return new ResponseEntity<>(academicYearData.get(), HttpStatus.OK);
	} else {
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
}
@PutMapping("/updateAcademicYear")
public ResponseEntity<?> updateAcademicYear(@RequestBody AcademicYearEntity academicYearEntity) {
	AcademicYearEntity academicYearData = masterService.updateAcademicYear(academicYearEntity);
	if (academicYearData != null) {
		return new ResponseEntity<>(academicYearData, HttpStatus.OK);
	} else {
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
}
@GetMapping("/getAllAcademicBatchYear")
public ResponseEntity<?> getAllAcademicBatchYear(){
	List<AcademicBatchYearEntity> list= masterService.getAllAcademicBatchYear();
	return new ResponseEntity<>(list, HttpStatus.OK);
}
}


