package com.ait.service;

import com.ait.dto.PlanDto;
import com.ait.dto.SummaryDto;

public interface EDService {

	public boolean eligibilityTest(SummaryDto summaryDto, PlanDto planDto);

	
}
