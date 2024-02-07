package com.sparrow.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
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
@Table(name = "spr_institute_basic")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class InstituteEntity extends BaseEntity{
	/**
	 * 
	 */
	private static final long serialVersionUID = 4381265887785219009L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="institute_id")
	
	private Long instituteId;
	
	@OneToOne
	@JoinColumn(name="fk_institute_type_id")
	private InstituteTypeEntity fkInstituteTypeId;
	@Column(name="inst_id_prefix")
	private String instituteIdPrefix;
	@Column(name="inst_name")
	private String instituteName;
	@Column(name="inst_addrs")
	private String instAddrs;
	@Column(name="inst_ph_no")
	private Long phNo;
	@Column(name="inst_email")
	private String email;
	@Column(name="inst_logo")
	private String instLogo;
	@Column(name="inst_Affilate_org")
	private String affiliateOrg;
	@Column(name="inst_Affilition_no")
	private String affiliationNo;
	@Column(name="inst_Affilition_dt")
	@JsonFormat(pattern = "yyyy-MM-dd")
	private String instAffilioationDt;
	@Column(name="is_active")
	private Boolean isActive;
	
	
	

}
