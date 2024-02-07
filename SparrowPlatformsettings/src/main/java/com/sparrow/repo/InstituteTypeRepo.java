package com.sparrow.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import com.sparrow.entity.InstituteTypeEntity;

public interface InstituteTypeRepo extends JpaRepository<InstituteTypeEntity, Long> {
	@Query(value = "select * from spr_institute_type where is_active=1",nativeQuery = true)
	List<InstituteTypeEntity> getAllActivelist();

}
