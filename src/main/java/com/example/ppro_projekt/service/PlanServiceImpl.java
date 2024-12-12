package com.example.ppro_projekt.service;

import com.example.ppro_projekt.model.Plan;
import com.example.ppro_projekt.repository.PlanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PlanServiceImpl implements PlanService {



    PlanRepository planRepository;
    @Autowired
    public PlanServiceImpl(PlanRepository planRepository) {
        this.planRepository = planRepository;
    }

    @Override
    public List<Plan> getAllPlans() {
        return planRepository.findAll();
    }

    @Override
    public Plan getPlanById(long id) {
        return planRepository.findById(id).orElse(null);
    }

    @Override
    public void deletePlanById(long id) {
        Optional<Plan> plan = planRepository.findById(id);
        if (plan.isPresent()) {
            planRepository.delete(plan.get());
        }
    }

    @Override
    public void savePlan(Plan plan) {
        planRepository.save(plan);
    }


}
