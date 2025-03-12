package br.com.fiap.checkpoint.dto;

import jakarta.validation.constraints.*;

import java.math.BigDecimal;
import java.time.LocalDate;

public record BookRequestDTO(
        @NotBlank(message = "{validationMessage.titleEmpty}")
        @Size(min = 1, max = 100, message = "{validationMessage.titleSize}")
        String title,

        @NotBlank(message = "{validationMessage.authorNameEmpty}")
        @Size(min = 2, max = 100, message = "{validationMessage.authorNameSize}")
        String authorName,

        @PastOrPresent(message = "{validationMessage.releaseDatePastOrPresent}")
        LocalDate releaseDate,

        @NotBlank(message = "{validationMessage.genreEmpty}")
        @Size(max = 50, message = "{validationMessage.genreSize}")
        String genre,

        @Min(value = 1, message = "{validationMessage.numberOfPagesMin}")
        @Max(value = 10000, message = "{validationMessage.numberOfPagesMax}")
        int numberOfPages,

        @Min(value = 1, message = "{validationMessage.priceMin}")
        BigDecimal price,

        @NotBlank(message = "{validationMessage.publisherEmpty}")
        String publisher,

        @Pattern(
                regexp = "^((\\+55\\s?)?\\(?\\d{2}\\)?\\s?9?\\d{4}[-\\s]?\\d{4}|\\+1\\s?\\(?\\d{3}\\)?\\s?\\d{3}[-\\s]?\\d{4})$",
                message = "{validationMessage.publisherPhonePattern}"
        )
        String publisherPhone
) {}
