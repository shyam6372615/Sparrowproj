package com.sparrow.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

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
@Table(name = "spr_academic_year")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AcademicYearEntity extends BaseEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="academic_setup-id")
	private Long academicSetupId;
	@OneToOne
	@JoinColumn(name="fk_institute_id")
	private InstituteEntity fkInstituteId;
	@Column(name="academic_year")
	private String academicYear;
	@Column(name="start_date")
	@JsonFormat(pattern = "yyyy-MM-dd")
	private String startDate;
	@Column(name="end_date")
	@JsonFormat(pattern = "yyyy-MM-dd")
	private String endDate;
	@OneToOne
	@JoinColumn(name="fk_batch_year_id")
	private AcademicBatchYearEntity fkBatchYearId;
	@Column(name="is_active")
	private Boolean isActive=true;

}
