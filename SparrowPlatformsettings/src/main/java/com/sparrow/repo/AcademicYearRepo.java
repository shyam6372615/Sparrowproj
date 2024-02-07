package com.sparrow.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.sparrow.entity.AcademicYearEntity;
import com.sparrow.entity.InstituteEntity;

public interface AcademicYearRepo extends JpaRepository<AcademicYearEntity, Long> {
	@Query(value = "select * from spr_academic_year where is_active=1",nativeQuery = true)
	List<AcademicYearEntity> getAllActivelist();


}
