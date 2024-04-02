package com.ait.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class SummaryDto {

	//after all data is saved, we need to give a summary page
	
	private IncomeDto income;
	private EducationDto education;
	private KidsDto kidsDto;           //instead of kid entity we take dto because one parents can have many kids
	
}
