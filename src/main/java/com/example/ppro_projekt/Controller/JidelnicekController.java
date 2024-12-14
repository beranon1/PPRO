package com.example.ppro_projekt.Controller;

import com.example.ppro_projekt.model.Jidelnicek;
import com.example.ppro_projekt.service.JidelnicekService;
import com.example.ppro_projekt.service.PlanService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/jidelniceks")
public class JidelnicekController {
    
    private JidelnicekService jidelnicekService;
    private PlanService planService;

    @Autowired
    public JidelnicekController(JidelnicekService jidelnicekService, PlanService planService) {
        this.jidelnicekService = jidelnicekService;
        this.planService = planService;
    }

    @GetMapping("/")
    public String list(Model model){
        model.addAttribute("jidelniceks", jidelnicekService.getAllJidelniceks());
        return "jidelnicek_list";
    }

    @GetMapping("/detail/{id}")
    public String detail(Model model, @PathVariable long id){
        Jidelnicek jidelnicek = jidelnicekService.getJidelnicekById(id);
        if (jidelnicek != null){
            model.addAttribute("jidelnicek", jidelnicek);
            return "jidelnicek_detail";
        }
        return "redirect:/jidelniceks/";
    }

    @GetMapping("/delete/{id}")
    public String delete(Model model, @PathVariable long id){
        jidelnicekService.deleteJidelnicekById(id);

        return "redirect:/jidelniceks/";
    }

    @GetMapping("/create")
    public String create(Model model){
        model.addAttribute("jidelnicek", new Jidelnicek());
        model.addAttribute("edit", false);
        model.addAttribute("plans", planService.getAllPlans());
        return "jidelnicek_edit";
    }

    @GetMapping("/edit/{id}")
    public String edit(Model model, @PathVariable long id){
        Jidelnicek jidelnicek = jidelnicekService.getJidelnicekById(id);
        if (jidelnicek != null){
            jidelnicek.setId(id);
            model.addAttribute("jidelnicek", jidelnicek);
            model.addAttribute("edit", true);
            model.addAttribute("plans", planService.getAllPlans());
            return "jidelnicek_edit";
        }
        return "redirect:/jidelniceks/";
    }

    @PostMapping("/save")
    public String save(@Valid Jidelnicek jidelnicek, BindingResult bindingResult, Model model){
        if (bindingResult.hasErrors()){
            model.addAttribute("edit", true);
            model.addAttribute("plans", planService.getAllPlans());
            return "jidelnicek_edit";
        }
        jidelnicekService.saveJidelnicek(jidelnicek);
        return "redirect:/jidelniceks/";
    }
}
