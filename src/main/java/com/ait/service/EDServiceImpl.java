package com.ait.service;

import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.RandomUtils;
import org.springframework.stereotype.Service;

import com.ait.dto.KidDto;
import com.ait.dto.PlanDto;
import com.ait.dto.SummaryDto;
import com.ait.entity.PlansEligibility;
import com.ait.repo.EligibilityRepo;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class EDServiceImpl implements EDService {

	private final EligibilityRepo eligibilityRepo;
	
	
	@Override
	public boolean eligibilityTest(SummaryDto summary, PlanDto plan) {
		PlansEligibility eligibility = new PlansEligibility();
		
		boolean status = false;

		
		if(plan.getPlanName().equalsIgnoreCase("SNAP") && summary.getIncome().getSalaryIncome() <= 20000.0    ||
		
		   plan.getPlanName().equalsIgnoreCase("CCAP")  && summary.getIncome().getSalaryIncome() <= 20000.0 && 
		   summary.getKidsDto().getKids().size() > 0 && checkKidsAge(summary.getKidsDto().getKids())                                          ||
		
           plan.getPlanName().equalsIgnoreCase("Medicaid") && summary.getIncome().getSalaryIncome() <= 20000.0
				&& summary.getIncome().getPropertyIncome() == 0                                               ||
		
		   plan.getPlanName().equalsIgnoreCase("Medicare") && checkSeniorAge()                                ||
		
	       plan.getPlanName().equalsIgnoreCase("RIW") && !summary.getEducation().getHighestDegree().equals("NA") ) {
			status = true;
		}
		
		if(status) {
			eligibility.setStatus("Approved");
			eligibility.setBenefitAmount(22000.0);
			eligibility.setEligibilityDeterminationDate(LocalDate.now());
			eligibility.setEligibilityStartdate(LocalDate.now());
			eligibility.setEligibilityEndDate(LocalDate.now().plusMonths(6));
		}else {
			eligibility.setStatus("Denied");
			eligibility.setDenialReason("Didn't meet the eligibility criteria for the selected plan");
		}
		eligibilityRepo.save(eligibility);
		return status;
	}
	
	
	
	private boolean checkKidsAge(List<KidDto> kids) {
		for(KidDto kidDto:kids) {
			LocalDate date = LocalDate.now();
			int years = Period.between(kidDto.getDob(), date).getYears();
			if(years > 16) {
				return false;
			}
		}		
		return true;
	}
	
	
	
	@SuppressWarnings("deprecation")
	private boolean checkSeniorAge() {
		LocalDate date= LocalDate.now();
		new Date(Math.abs(System.currentTimeMillis() - RandomUtils.nextLong()));          //get random dob
		Date input = new Date();  
		LocalDate dob = input.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();   //convert date to local date
		
		int years = Period.between(dob, date).getYears();
		if(years >= 65)
			return true;
		else 
			return false;
	}
	
}
