package com.example.ppro_projekt.Controller;



import com.example.ppro_projekt.model.Cvik;
import com.example.ppro_projekt.service.CvikService;
import com.example.ppro_projekt.service.PlanService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/cviks")
public class CvikController {

    private CvikService cvikService;
    private PlanService planService;

    @Autowired
    public CvikController(CvikService cvikService, PlanService planService) {
        this.cvikService = cvikService;
        this.planService = planService;
    }

    @GetMapping("/")
    public String list(Model model){
        model.addAttribute("cviks", cvikService.getAllCviks());
        return "cvik_list";
    }

    @GetMapping("/detail/{id}")
    public String detail(Model model, @PathVariable long id){
        Cvik cvik = cvikService.getCvikById(id);
        if (cvik != null){
            model.addAttribute("cvik", cvik);
            return "cvik_detail";
        }
        return "redirect:/cviks/";
    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/delete/{id}")
    public String delete(Model model, @PathVariable long id){
        cvikService.deleteCvikById(id);
        return "redirect:/cviks/";
    }


    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/create")
    public String create(Model model){
        model.addAttribute("cvik", new Cvik());
        model.addAttribute("edit", false);
        model.addAttribute("plans", planService.getAllPlans());
        return "cvik_edit";
    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/edit/{id}")
    public String edit(Model model, @PathVariable long id){
        Cvik cvik = cvikService.getCvikById(id);
        if (cvik != null){
            cvik.setId(id);
        model.addAttribute("cvik", cvik);
        model.addAttribute("edit", true);
        model.addAttribute("plans", planService.getAllPlans());
            return "cvik_edit";
        }
        return "redirect:/cviks/";
    }

    @PostMapping("/save")
    public String save(@Valid Cvik cvik, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("edit", true);
            model.addAttribute("plans", planService.getAllPlans());
            return "cvik_edit";
        }
        cvikService.saveCvik(cvik);
        return "redirect:/cviks/";
    }
}
