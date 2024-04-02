package com.ait.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.ait.dto.SummaryDto;


//@FeignClient(name = "DC-api")
@FeignClient(name = "DC-API-TESTT")
public interface DcApiClient {


	//@GetMapping("/summary/{appNumber}")
	//public SummaryDto invokeGetSummaryData(@PathVariable Integer appNumber);
	
	@GetMapping("/summary/{appNumber}")
	public SummaryDto getSummary(@PathVariable("appNumber") Integer appNumber);
		
}


//No need of income,education,kid because summaryDto will have it all

	
	
