package com.example.ppro_projekt.Controller;



import com.example.ppro_projekt.model.Plan;
import com.example.ppro_projekt.service.PlanService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/plans")
public class PlanController {

    private PlanService planService;

    @Autowired
    public PlanController(PlanService planService) {
        this.planService = planService;
    }

    @GetMapping("/")
    public String list(Model model){
        model.addAttribute("plans", planService.getAllPlans());
        return "plan_list";
    }

    @GetMapping("/detail/{id}")
    public String detail(Model model, @PathVariable long id){
        Plan plan = planService.getPlanById(id);
        if (plan != null){
            model.addAttribute("plan", plan);
            return "plan_detail";
        }
        return "redirect:/plans/";
    }

    @GetMapping("/delete/{id}")
    public String delete(Model model, @PathVariable long id){
        planService.deletePlanById(id);
        return "redirect:/plans/";
    }

    @GetMapping("/create")
    public String create(Model model){
        model.addAttribute("plan", new Plan());
        model.addAttribute("edit", false);
        return "plan_edit";
    }

    @GetMapping("/edit/{id}")
    public String edit(Model model, @PathVariable long id){
        Plan plan = planService.getPlanById(id);
        if (plan != null){
            plan.setId(id);
        model.addAttribute("plan", plan);
        model.addAttribute("edit", true);
        return "plan_edit";
        }
        return "redirect:/plans/";
    }

    @PostMapping("/save")
    public String save(@Valid Plan plan, BindingResult bindingResult, Model model){
        if (bindingResult.hasErrors()){
            model.addAttribute("edit", true);
            return "plan_edit";
        }
        planService.savePlan(plan);
        return "redirect:/plans/";
    }


}
