package br.com.fiap.checkpoint.dto;

public record BookDTO(
        String title,
        String authorName,
        java.time.LocalDate releaseDate,
        String genre,
        int numberOfPages
) {}
