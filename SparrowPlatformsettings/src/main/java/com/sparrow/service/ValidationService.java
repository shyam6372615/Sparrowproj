package com.sparrow.service;



import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.sparrow.dto.Response;
import com.sparrow.entity.AcademicYearEntity;
import com.sparrow.entity.InstituteEntity;
@Service
public class ValidationService {
	public Response<?> validateForInstituteAdd(InstituteEntity instEntity){
		
		if(instEntity.getAffiliateOrg()==null) {
			return new Response<>(HttpStatus.BAD_REQUEST.value(),"Please provide the Affiloate Organisation!!",null);
		} 
		else if(instEntity.getAffiliationNo()==null) {
			return new Response<>(HttpStatus.BAD_REQUEST.value(),"Please provide the Affilioation No!!",null);
		}
		else if(instEntity.getEmail()==null) {
			return new Response<>(HttpStatus.BAD_REQUEST.value(),"Please select the emailId!!",null);
		}
		else if(instEntity.getFkInstituteTypeId()==null) {
			return new Response<>(HttpStatus.BAD_REQUEST.value(),"Please provide the InstituteType!!",null);
		}
		else if(instEntity.getInstAddrs()==null) {
			return new Response<>(HttpStatus.BAD_REQUEST.value(),"Please provide the Institute Address!!",null);
		}
		else if(instEntity.getInstituteIdPrefix()==null) {
			return new Response<>(HttpStatus.BAD_REQUEST.value(),"Please provide the Institute Id prefix !!",null);
		}
		else if(instEntity.getInstituteName()==null) {
			return new Response<>(HttpStatus.BAD_REQUEST.value(),"Please provide the Institute Name!!",null);
		}
		else if(instEntity.getInstLogo()==null) {
			return new Response<>(HttpStatus.BAD_REQUEST.value(),"Please provide the Institute Logo!!",null);
		}
		else if(instEntity.getPhNo()==null) {
			return new Response<>(HttpStatus.BAD_REQUEST.value(),"Please provide the Institute Contact no!!",null);
		}
		
		
		else {
			return new Response<>(HttpStatus.OK.value(),"ok",null);
		}

}
	public Response<?> validateForAcademicYearAdd(AcademicYearEntity academicYearEntity){
		if(academicYearEntity.getAcademicYear()==null) {
			return new Response<>(HttpStatus.BAD_REQUEST.value(),"Please provide Academic Year!!",null);
		} 
		else if(academicYearEntity.getEndDate()==null) {
			return new Response<>(HttpStatus.BAD_REQUEST.value(),"Please provide Academic Year End Date!!",null);
		}
		else if(academicYearEntity.getFkBatchYearId()==null) {
			return new Response<>(HttpStatus.BAD_REQUEST.value(),"Please select the Batch Start Year!!",null);
		}else if(academicYearEntity.getStartDate()==null) {
			return new Response<>(HttpStatus.BAD_REQUEST.value(),"Please provide Academic Year Start Date!!",null);
		}else {
			return new Response<>(HttpStatus.OK.value(),"ok",null);
		}
		}
}
