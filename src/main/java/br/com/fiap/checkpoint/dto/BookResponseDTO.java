package br.com.fiap.checkpoint.dto;

import java.math.BigDecimal;

public record BookResponseDTO(
        Long id,
        String title,
        String authorName,
        java.time.LocalDate releaseDate,
        String genre,
        int numberOfPages,
        String publisher,
        String publisherPhone,
        BigDecimal price
) {}
