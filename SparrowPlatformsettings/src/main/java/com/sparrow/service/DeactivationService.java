package com.sparrow.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.sparrow.dto.Response;
import com.sparrow.entity.AcademicYearEntity;
import com.sparrow.entity.InstituteEntity;
import com.sparrow.repo.AcademicYearRepo;
import com.sparrow.repo.InstituteRepo;
@Service
public class DeactivationService {
	@Autowired
	private InstituteRepo instRepo;
	@Autowired
	private AcademicYearRepo acdmRepo;
	
	
	public Response<?> deactivateInstitute(Long id) {
	    Optional<InstituteEntity> existingInstData = instRepo.findById(id);

	    if (existingInstData.isPresent()) {
	    	existingInstData.get().setIsActive(false);
	    	instRepo.save(existingInstData.get());
	        return new Response<>(HttpStatus.OK.value(), "Institute status updated successfully", null);
	    } else {
	        
	        return new Response<>(HttpStatus.NOT_FOUND.value(), "Institute not found", null);
	    }
	}
	public Response<?> deactivatAcademicYear(Long id) {
	    Optional<AcademicYearEntity> existingacdmYearData = acdmRepo.findById(id);

	    if (existingacdmYearData.isPresent()) {
	    	existingacdmYearData.get().setIsActive(false);
	    	acdmRepo.save(existingacdmYearData.get());
	        return new Response<>(HttpStatus.OK.value(), "Academic Year status updated successfully", null);
	    } else {
	        
	        return new Response<>(HttpStatus.NOT_FOUND.value(), "Academic Year  not found", null);
	    }
	}

}
