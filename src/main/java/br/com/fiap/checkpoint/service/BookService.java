package br.com.fiap.checkpoint.service;

import br.com.fiap.checkpoint.dto.BookDTO;
import br.com.fiap.checkpoint.model.Book;
import br.com.fiap.checkpoint.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

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
                ).toList();
    }

    public void createBook(BookDTO dto){
        Book book = new Book();
        book.setTitle(dto.title());
        book.setAuthorName(dto.authorName());
        book.setReleaseDate(LocalDate.now());
        book.setGenre(dto.genre());
        book.setNumberOfPages(dto.numberOfPages());
        repository.save(book);
    }
}
