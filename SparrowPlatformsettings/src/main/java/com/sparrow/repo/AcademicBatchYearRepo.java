package com.sparrow.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.sparrow.entity.AcademicBatchYearEntity;
import com.sparrow.entity.AcademicYearEntity;

public interface AcademicBatchYearRepo extends JpaRepository<AcademicBatchYearEntity, Long> {
	@Query(value = "select * from spr_batch_year where is_active=1",nativeQuery = true)
	List<AcademicBatchYearEntity> getAllActivelist();


}
