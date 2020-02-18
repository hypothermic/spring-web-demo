package nl.hypothermic.demo.controller;

import nl.hypothermic.demo.api.model.Form;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Component
@Controller
public class FormController {

    @Autowired
    private ApplicationContext applicationContext;

    @GetMapping(value = "/form", produces = "text/html")
    public String register(Model model) {
        model.addAttribute("formObject", applicationContext.getBean(Form.class));
        return "form";
    }

    @PostMapping("/submit")
    public String submit(@ModelAttribute("formObject") @Validated Form formObject, BindingResult bindingResult, Model model) {
        if (formObject == null || bindingResult.hasErrors()) {
            model.addAttribute("message", "FAILED");
            return "form";
        }

        model.addAttribute("message", "SUCCESS");
        return "forward:/completed.html";
    }
}
