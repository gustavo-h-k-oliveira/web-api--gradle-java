package application.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("/")
public class IndexController {
    // Método GET
    @GetMapping
    public String home() {
        return "home";
    }

    // Método POST
    @PostMapping
    public String postHome() {
        return "post home";
    }
}
