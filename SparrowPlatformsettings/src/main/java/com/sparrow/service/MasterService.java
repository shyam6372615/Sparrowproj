package com.sparrow.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.sparrow.dto.Response;
import com.sparrow.entity.AcademicBatchYearEntity;
import com.sparrow.entity.AcademicYearEntity;
import com.sparrow.entity.InstituteEntity;
import com.sparrow.entity.InstituteTypeEntity;
import com.sparrow.repo.AcademicBatchYearRepo;
import com.sparrow.repo.AcademicYearRepo;
import com.sparrow.repo.InstituteRepo;
import com.sparrow.repo.InstituteTypeRepo;



@Service
public class MasterService {
	@Autowired
	private InstituteRepo instRepo;
	@Autowired
	private InstituteTypeRepo instTypeRepo;
	@Autowired
	private AcademicYearRepo acdmRepo;
	@Autowired
	private AcademicBatchYearRepo acdmBatchRepo;
	

	
	public Response<?> addInstitute(InstituteEntity instEntity) {
		
		InstituteEntity inst =instRepo.save(instEntity);
		return new Response<>(HttpStatus.CREATED.value(), "Institute Created Successfully!!", inst);
	}
	
	public List<InstituteEntity> getAllInstitute(){
		return instRepo.getAllActivelist();
		
	}
	public Optional<?> getInstituteById(long id) {
		return instRepo.findById(id);
	}
	
	public InstituteEntity updateInstitute(InstituteEntity instEntity) {
		Optional<InstituteEntity> optional=instRepo.findById(instEntity.getInstituteId());
		InstituteEntity existingInstEntity=optional.get();
		
			existingInstEntity.setAffiliateOrg(instEntity.getAffiliateOrg());
			existingInstEntity.setAffiliationNo(instEntity.getAffiliationNo());
			existingInstEntity.setEmail(instEntity.getEmail());
			existingInstEntity.setFkInstituteTypeId(instEntity.getFkInstituteTypeId());
			existingInstEntity.setInstAddrs(instEntity.getInstAddrs());
			existingInstEntity.setInstAffilioationDt(instEntity.getInstAffilioationDt());
			existingInstEntity.setInstituteIdPrefix(instEntity.getInstituteIdPrefix());
			existingInstEntity.setInstituteName(instEntity.getInstituteName());
			existingInstEntity.setInstLogo(instEntity.getInstLogo());
			existingInstEntity.setIsActive(true);
			existingInstEntity.setPhNo(instEntity.getPhNo());
			InstituteEntity updatedInstData=instRepo.save(existingInstEntity);
			return updatedInstData;
			
		}
	
	public List<InstituteTypeEntity> getAllInstituteType(){
		return instTypeRepo.getAllActivelist();
		
	}
    public Response<?> addAcademicYear(AcademicYearEntity acdmYearEntity) {
		
	      AcademicYearEntity academicYearData =acdmRepo.save(acdmYearEntity);
		return new Response<>(HttpStatus.CREATED.value(), "Academic Year Added Successfully!!", academicYearData);
	}
    public List<AcademicYearEntity> getAllAcademicYear(){
		return acdmRepo.getAllActivelist();
		
	}
    public Optional<?> getAcademicYearById(long id) {
		return acdmRepo.findById(id);
	
	
    }
    public AcademicYearEntity updateAcademicYear(AcademicYearEntity acdmYearEntity) {
		Optional<AcademicYearEntity> optional=acdmRepo.findById(acdmYearEntity.getAcademicSetupId());
		AcademicYearEntity existingAcdmYearEntity=optional.get();
		existingAcdmYearEntity.setAcademicYear(acdmYearEntity.getAcademicYear());
		existingAcdmYearEntity.setEndDate(acdmYearEntity.getEndDate());
		existingAcdmYearEntity.setFkBatchYearId(acdmYearEntity.getFkBatchYearId());
		existingAcdmYearEntity.setFkInstituteId(acdmYearEntity.getFkInstituteId());
		existingAcdmYearEntity.setStartDate(acdmYearEntity.getStartDate());
		existingAcdmYearEntity.setIsActive(true);
		AcademicYearEntity updatedAcademicYearData=acdmRepo.save(existingAcdmYearEntity);
		
		return updatedAcademicYearData;

}
    public List<AcademicBatchYearEntity> getAllAcademicBatchYear(){
		return acdmBatchRepo.getAllActivelist();
		
	}
}
