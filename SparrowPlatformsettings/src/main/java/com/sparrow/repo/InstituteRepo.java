package com.sparrow.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.sparrow.entity.InstituteEntity;



public interface InstituteRepo extends JpaRepository<InstituteEntity, Long> {
	@Query(value = "select institute_type_name from spr_institute_type where is_active=1",nativeQuery = true)
	List<InstituteEntity> getAllActivelist();

}
