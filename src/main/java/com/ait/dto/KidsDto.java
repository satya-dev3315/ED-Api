package com.ait.dto;

import java.util.List;



import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class KidsDto {

	//There can we multiple kids for parents, so we r using this class
	
	private Integer appNumber;   // kid belongs to which app
	private List<KidDto> kids;
	
}
