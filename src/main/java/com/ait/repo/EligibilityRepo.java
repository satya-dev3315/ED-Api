package com.ait.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ait.entity.PlansEligibility;

public interface EligibilityRepo extends JpaRepository<PlansEligibility, Integer> {

}
