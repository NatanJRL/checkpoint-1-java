package br.com.fiap.checkpoint.service;

import br.com.fiap.checkpoint.dto.BookDTO;
import br.com.fiap.checkpoint.model.Book;
import br.com.fiap.checkpoint.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookService {

    @Autowired
    private BookRepository repository;

    public List<BookDTO> getAllBooks(){
        List<Book> books = repository.findAll();
        return books.stream().map(
                book -> {
                    return new BookDTO(
                            book.getTitle(),
                            book.getAuthorName(),
                            book.getReleaseDate(),
                            book.getGenre(),
                            book.getNumberOfPages());
                }
                ).collect(Collectors.toList());
    }
}
