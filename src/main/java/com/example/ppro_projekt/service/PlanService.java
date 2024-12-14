package com.example.ppro_projekt.service;

import com.example.ppro_projekt.model.Plan;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PlanService {

    List<Plan> getAllPlans();
    Plan getPlanById(long id);
    void deletePlanById(long id);
    void savePlan(Plan plan);

}
