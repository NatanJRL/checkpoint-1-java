package br.com.fiap.checkpoint.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String redirectToBooksList() {
        return "redirect:/books/list";
    }
}