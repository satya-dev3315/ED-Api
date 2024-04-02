package com.ait.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.ait.dto.PlanDto;

@FeignClient(name="Plans-Api")
public interface PlanApiClient {
	
	@GetMapping("/plan/{planId}")
	public PlanDto invokeGetPlanData(@PathVariable Integer planId);
	
}
