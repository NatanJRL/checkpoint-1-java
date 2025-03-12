package br.com.fiap.checkpoint.service;

import br.com.fiap.checkpoint.dto.BookRequestDTO;
import br.com.fiap.checkpoint.dto.BookResponseDTO;
import br.com.fiap.checkpoint.model.Book;
import br.com.fiap.checkpoint.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    @Autowired
    private BookRepository repository;

    public List<BookResponseDTO> getAllBooks(){
        List<Book> books = repository.findAll();
        return books.stream().map(
                book -> {
                    return new BookResponseDTO(
                            book.getId(),
                            book.getTitle(),
                            book.getAuthorName(),
                            book.getReleaseDate(),
                            book.getGenre(),
                            book.getNumberOfPages(),
                            book.getPublisher(),
                            book.getPublisherPhone(),
                            book.getPrice());
                }
                ).toList();
    }

    public void createBook(BookRequestDTO dto){
        Book book = new Book();
        book.setTitle(dto.title());
        book.setAuthorName(dto.authorName());
        book.setReleaseDate(LocalDate.now());
        book.setGenre(dto.genre());
        book.setNumberOfPages(dto.numberOfPages());
        book.setPublisher(dto.publisher());
        book.setPrice(dto.price());
        book.setPublisherPhone(dto.publisherPhone());
        repository.save(book);
    }

    public void delete(Long id){
        if (repository.existsById(id)){
            repository.deleteById(id);
        }
    }

    public BookResponseDTO getById(Long id){
        Optional<Book> bookById =  repository.findById(id);
        if (bookById.isEmpty()){
            throw new IllegalArgumentException("Livro de id " + id + " nao encontrado");
        }
        return new BookResponseDTO(
                bookById.get().getId(),
                bookById.get().getTitle(),
                bookById.get().getAuthorName(),
                bookById.get().getReleaseDate(),
                bookById.get().getGenre(),
                bookById.get().getNumberOfPages(),
                bookById.get().getPublisher(),
                bookById.get().getPublisherPhone(),
                bookById.get().getPrice());
    }

    public void update(Long id, BookRequestDTO dto) {
        Optional<Book> book = repository.findById(id);
        if (book.isPresent()){
            if (dto.title() != null){
                book.get().setTitle(dto.title());
            }
            if (dto.authorName() != null){
                book.get().setAuthorName(dto.authorName());
            }
            if (dto.releaseDate() != null){
                book.get().setReleaseDate(dto.releaseDate());
            }
            if (dto.genre() != null){
                book.get().setGenre(dto.genre());
            }
            if (dto.numberOfPages() > 0){
                book.get().setNumberOfPages(dto.numberOfPages());
            }
            if (dto.publisher() != null){
                book.get().setPublisher(dto.publisher());
            }
            if (dto.price() != null){
                book.get().setPrice(dto.price());
            }
            if (dto.publisherPhone() != null){
                book.get().setPublisherPhone(dto.publisherPhone());
            }
            repository.save(book.get());
        }

    }
}
