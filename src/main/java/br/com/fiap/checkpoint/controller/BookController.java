package br.com.fiap.checkpoint.controller;

import br.com.fiap.checkpoint.dto.BookRequestDTO;
import br.com.fiap.checkpoint.dto.BookResponseDTO;
import br.com.fiap.checkpoint.model.Book;
import br.com.fiap.checkpoint.service.BookService;
import jakarta.validation.Valid;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/books")
public class  BookController {

    @Autowired
    private BookService service;


    @GetMapping("list")
    private String get(Model model){
        model.addAttribute("books", service.getAllBooks());
        return "books/list";
    }

    @GetMapping("/new")
    public String showForm(Model model){
        model.addAttribute("book", new Book());
        return "books/add";
    }

    @PostMapping("/add")
    private String post(@ModelAttribute("book") @Valid BookRequestDTO dto, BindingResult bindingResult, Model model){
        if (bindingResult.hasErrors()) {
            model.addAttribute("book", dto);
            return "books/add";
        }
        service.createBook(dto);
        return "redirect:list";
    }

    @PostMapping("/update/{id}")
    private String put(@PathVariable Long id, @ModelAttribute("book") @Valid BookRequestDTO dto, BindingResult result, Model model){
        if (result.hasErrors()) {
            model.addAttribute("book", dto);
            return "books/update";
        }
        service.update(id, dto);
        return "redirect:/books/list";
    }

    @GetMapping("/form/{id}")
    public String showUpdateForm(@PathVariable Long id, Model model) {
        BookResponseDTO book = service.getById(id);
        model.addAttribute("book", book);
        model.addAttribute("id", id);
        return "books/update";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id, Model model){
        service.delete(id);
        return "redirect:/books/list";
    }


}
