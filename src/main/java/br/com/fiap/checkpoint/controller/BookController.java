package br.com.fiap.checkpoint.controller;

import br.com.fiap.checkpoint.dto.BookDTO;
import br.com.fiap.checkpoint.model.Book;
import br.com.fiap.checkpoint.service.BookService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/books")
public class BookController {

    @Autowired
    private BookService service;

    @GetMapping("/list")
    private String read(Model model){
        model.addAttribute("books", service.getAllBooks());
        return "books/list";
    }

    @PostMapping("/add")
    private String create(@ModelAttribute @Valid BookDTO dto, Model model){
        System.out.println(dto);
        service.createBook(dto);
        return "redirect:list";
    }

    @GetMapping("/new")
    public String novoProduto(Model model){
        model.addAttribute("book", new Book());
        return "books/add";
    }
}
