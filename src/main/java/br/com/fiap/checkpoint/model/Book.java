package br.com.fiap.checkpoint.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.UUID;


@Entity(name = "Book")
@Data
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID uuid;

    @Column
    private String title;

    @Column
    private String authorName;

    @Column
    private Date releaseDate;

    @Column
    private String genre;

    @Column
    private int numberOfPages;
}
