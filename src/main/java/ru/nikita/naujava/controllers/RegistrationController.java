package ru.nikita.naujava.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import ru.nikita.naujava.entities.User;
import ru.nikita.naujava.services.UserService;

@Controller
@RequiredArgsConstructor
public class RegistrationController {

    private final UserService userService;

    @GetMapping("/registration")
    public String registration(Model model) {
        model.addAttribute("user", new User());
        return "registration";
    }

    @PostMapping("/registration")
    public String adduser(Model model, @ModelAttribute User user) {
        if (!userService.addUser(user)) {
            model.addAttribute("message", "User exists");
            return "registration";
        }
        return "redirect:/login";
    }

    @GetMapping("/")
    public String menu() {
        return "menu";
    }
}
