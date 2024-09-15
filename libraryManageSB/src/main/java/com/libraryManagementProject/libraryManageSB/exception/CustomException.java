package com.libraryManagementProject.libraryManageSB.exception;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CustomException {
    @ExceptionHandler(Exception.class)
    public String handlingException(Exception e, Model model){

        model.addAttribute("mass",e.getMessage());
        return "myerror";
    }
}
