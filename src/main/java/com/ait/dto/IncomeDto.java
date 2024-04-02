package com.ait.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class IncomeDto {

	private Integer incomeId;
	
	private Double salaryIncome;
	
	private Double propertyIncome;
	
	private Integer appNumber;
	
}
