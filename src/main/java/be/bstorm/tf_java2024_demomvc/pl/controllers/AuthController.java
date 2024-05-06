package be.bstorm.tf_java2024_demomvc.pl.controllers;

import be.bstorm.tf_java2024_demomvc.pl.models.forms.LoginForm;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/auth")
public class AuthController {


    @GetMapping("/login")
    public String login(Model model) {

        model.addAttribute("form", new LoginForm());
        return "auth/login";
    }

    @PostMapping("/login")
    public String loginSubmit(
            @ModelAttribute("form") @Valid LoginForm form,
            BindingResult bindingResult,
            Model model,
            HttpSession session) {
        if(bindingResult.hasErrors()) {
            model.addAttribute("form", form);
            return "auth/login";
        }
        session.setAttribute("cUser", form.getUsername());
        return "redirect:/";
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.removeAttribute("cUser");
        session.invalidate();
        return "redirect:/";
    }

}
