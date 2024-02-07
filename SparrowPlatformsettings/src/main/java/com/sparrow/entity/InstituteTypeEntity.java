package com.sparrow.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "spr_institute_type")
@Data
@AllArgsConstructor
@NoArgsConstructor

public class InstituteTypeEntity extends BaseEntity {
	/**
	 * 
	 */
	private static final long serialVersionUID = 4381265887735219009L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="institute_type_id")
	private Long instituteTypeId;
	
	@Column(name="institute_type_name")
	private String InstituteTypeName;
	@Column(name="is_active")
	private Boolean isActite=true;
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
