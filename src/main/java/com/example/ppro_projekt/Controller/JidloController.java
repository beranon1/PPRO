package com.example.ppro_projekt.Controller;
import com.example.ppro_projekt.model.Jidlo;
import com.example.ppro_projekt.service.JidelnicekService;
import com.example.ppro_projekt.service.JidloService;
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
@RequestMapping("/jidlos")
public class JidloController {

    private JidelnicekService jidelnicekService;
    private JidloService jidloService;

    @Autowired
    public JidloController(JidloService jidloService, JidelnicekService jidelnicekService) {
        this.jidloService = jidloService;
        this.jidelnicekService = jidelnicekService;
    }

    @GetMapping("/")
    public String list(Model model){
        model.addAttribute("jidlos", jidloService.getAllJidlos());
        return "jidlo_list";
    }

    @GetMapping("/detail/{id}")
    public String detail(Model model, @PathVariable long id){
        Jidlo jidlo = jidloService.getJidloById(id);
        if (jidlo != null){
            model.addAttribute("jidlo", jidlo);
            return "jidlo_detail";
        }
        return "redirect:/jidlos/";
    }

    @GetMapping("/delete/{id}")
    public String delete(Model model, @PathVariable long id){
        jidloService.deleteJidloById(id);
        return "redirect:/jidlos/";
    }

    @GetMapping("/create")
    public String create(Model model){
        model.addAttribute("jidlo", new Jidlo());
        model.addAttribute("edit", false);
        model.addAttribute("jidelniceks", jidelnicekService.getAllJidelniceks());
        return "jidlo_edit";
    }

    @GetMapping("/edit/{id}")
    public String edit(Model model, @PathVariable long id){
        Jidlo jidlo = jidloService.getJidloById(id);
        if (jidlo != null){
            jidlo.setId(id);
            model.addAttribute("jidlo", jidlo);
            model.addAttribute("edit", true);
            model.addAttribute("jidelniceks", jidelnicekService.getAllJidelniceks());
            return "jidlo_edit";
        }
        return "redirect:/jidlos/";
    }

    @PostMapping("/save")
    public String save(@Valid Jidlo jidlo, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("edit", true);
            model.addAttribute("jidelniceks", jidelnicekService.getAllJidelniceks());
            return "jidlo_edit";
        }
        jidloService.saveJidlo(jidlo);
        return "redirect:/jidlos/";
    }
}
