package com.ait.dto;

import java.time.LocalDate;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class KidDto {
	
	private Integer kidId;
	
	private String kidName;
	
	private LocalDate dob;
	
	private Long ssn;
	
	private Integer appNumber;   // kid belongs to which app, appNumber will act as a foreign key here
	
}
