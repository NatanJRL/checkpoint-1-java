package br.com.fiap.checkpoint.controller;

import br.com.fiap.checkpoint.dto.BookDTO;
import br.com.fiap.checkpoint.service.BookService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    private BookService service;

    private List<BookDTO> getAll(Model model){
        model.addAttribute("books", service.getAllBooks());
        return "books/list";
    }

    private void post(@Valid BookDTO dto, Model model){

    }
}
