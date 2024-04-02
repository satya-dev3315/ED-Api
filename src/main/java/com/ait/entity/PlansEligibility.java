package com.ait.entity;

import java.time.LocalDate;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name =  "plans_eligibility")
public class PlansEligibility {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "eligibility_id")
	private Integer eligibilityId;
	
	@Column(name = "app_number")
	private Integer appNumber;
	
	private String status;
	
	@Column(name = "eligibility_start_date")
	private LocalDate eligibilityStartdate;
	
	@Column(name = "eligibility_end_date")
	private LocalDate eligibilityEndDate;
	
	@Column(name = "benefit_amount")
	private Double benefitAmount;
	
	@Column(name = "denial_reason")
	private String denialReason;
	
	@Column(name = "eligibility_determination_date")
	private LocalDate eligibilityDeterminationDate;
	
	@CreationTimestamp
	@Column(name = "created_date")
	private LocalDate createdDate;
	
	@UpdateTimestamp
	@Column(name = "updated_date")
	private LocalDate updatedDate;
	

	
}
