package br.com.fiap.checkpoint.dto;

import java.util.Date;

public record BookDTO(
        String title,
        String authorName,
        Date releaseDate,
        String genre,
        int numberOfPages
) {}
