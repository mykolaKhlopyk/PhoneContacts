package com.scisw.phonecontacts.exceptions;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class ApplicationExceptionHandler {
    @ExceptionHandler(ContactNotExistException.class)
    public ModelAndView handleContactNotExistException(Exception exception) {
        ModelAndView modelAndView =
                new ModelAndView("error", HttpStatus.NOT_FOUND);
        modelAndView.addObject("info", "contact not exist");
        return modelAndView;
    }


    @ExceptionHandler(IncorrectEmailOrPhoneException.class)
    public ModelAndView handleIncorrectEmailOrPhoneException(Exception exception){
        ModelAndView modelAndView = new ModelAndView("error", HttpStatus.BAD_REQUEST);
        modelAndView.addObject("info", exception.getMessage());
        return modelAndView;
    }


}