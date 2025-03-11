package br.com.fiap.checkpoint.dto;

import jakarta.validation.constraints.*;
import org.springframework.validation.annotation.Validated;

import java.math.BigDecimal;
import java.time.LocalDate;

public record BookRequestDTO(
        @NotBlank(message = "O título não pode estar em branco")
        @Size(min = 1, max = 100, message = "O título deve ter entre 1 e 100 caracteres")
        String title,

        @NotBlank(message = "O nome do autor não pode estar em branco")
        @Size(min = 2, max = 100, message = "O nome do autor deve ter entre 2 e 100 caracteres")
        String authorName,

        @PastOrPresent(message = "A data de publicação não pode ser no futuro")
        @NotBlank(message = "A data de publicação não pode estar em branco")
        LocalDate releaseDate,

        @NotBlank(message = "O gênero não pode estar em branco")
        @Size(max = 50, message = "O gênero deve ter no máximo 50 caracteres")
        String genre,

        @Min(value = 1, message = "O número de páginas deve ser no mínimo 1")
        @Max(value = 10000, message = "O número de páginas deve ser no máximo 10.000")
        int numberOfPages,


        @Min(value = 1, message = "O valor precisa ser maior do que 1 real")
        BigDecimal price,

        @NotBlank(message = "A editora não pode estar em branco")
        String publisher
) {}
