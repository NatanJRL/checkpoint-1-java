package br.com.fiap.checkpoint;

import jakarta.validation.UnexpectedTypeException;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public String handleException(Exception ex, Model model){
        model.addAttribute("ex", ex);
        return "error";
    }

    @ExceptionHandler(UnexpectedTypeException.class)
    public String handleUnexpectedTypeException(UnexpectedTypeException ex, Model model) {
        model.addAttribute("errorMessage", ex.getMessage());
        return "error";
    }
}
