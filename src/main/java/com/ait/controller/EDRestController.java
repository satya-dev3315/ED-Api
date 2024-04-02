package com.ait.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.ait.dto.PlanDto;
import com.ait.dto.SummaryDto;
import com.ait.feign.DcApiClient;
import com.ait.feign.PlanApiClient;
import com.ait.service.EDService;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class EDRestController {
	
	
	private final DcApiClient dcApiClient;
	private final PlanApiClient planApiClient;
	private final EDService edService;
	
	
	@GetMapping("/eligibility/{planId}/{appNumber}")
	public ResponseEntity<String> eligibilityCriteria(@PathVariable Integer planId, @PathVariable Integer appNumber) {
		
		PlanDto planData = planApiClient.invokeGetPlanData(planId);
		//SummaryDto summaryData = dcApiClient.invokeGetSummaryData(appNumber);
		SummaryDto summaryData = dcApiClient.getSummary(appNumber);
		boolean status = edService.eligibilityTest(summaryData, planData);
		if(status) {
			return new ResponseEntity<>("Citizen is approved for plan : " + planData.getPlanName(), HttpStatus.OK);
		}
		return new ResponseEntity<>("Citizen is rejected", HttpStatus.FORBIDDEN);
	}
	
	
	@GetMapping("/summary/{appNumber}")
	public ResponseEntity<SummaryDto> getSummaryFromDC(@PathVariable Integer appNumber){
		SummaryDto summaryData = dcApiClient.getSummary(appNumber);
		return new ResponseEntity<>(summaryData, HttpStatus.OK);
	}
//get individual summary data (which includes income,education,kids info) using appNo frm another api using feign client
	
	
//how to send req to kid method
	
//	{
//		  "appNumber": 5,
//		  "kids": [
//		    {
//		      "kidId": 0,
//		      "kidName": "string",
//		      "dob": "2024-03-29",
//		      "ssn": 455544,
//		      "appNumber": 5,
//		      "createdDate": "2024-03-29",
//		      "updatedDate": "2024-03-29"
//		    }
//		  ]
//		}
}
