package com.ait.dto;

import java.time.LocalDate;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class PlanDto {
	
	private Integer planId;
	
	private String planName;
	
	private String comments;
	
	private String activeSwitch;
	
	private LocalDate startDate;
	
	private LocalDate endDate;
	
}
