package moviecom.example.movieapp.advice;


import moviecom.example.movieapp.Exception.EmptyInputException;
import moviecom.example.movieapp.Exception.EntityExistsException1;
import moviecom.example.movieapp.Exception.EntityNotExistsException;
import moviecom.example.movieapp.Exception.NotFoundException;
import moviecom.example.movieapp.model.AppResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class MyControllerAdvice extends RuntimeException {

    @ExceptionHandler(EmptyInputException.class)
    public ResponseEntity<Object> handleEmptyInput(EmptyInputException emptyInputException) {
        AppResponse appResponse = new AppResponse(HttpStatus.BAD_REQUEST.value(), false, emptyInputException.getErrorMessage());
        return new ResponseEntity<Object>(appResponse, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<Object> handleNotFoundException(NotFoundException notFoundException) {
        AppResponse appResponse = new AppResponse(HttpStatus.NOT_FOUND.value(), false, notFoundException.getErrorMessage());
        return new ResponseEntity<Object>(appResponse, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(EntityExistsException1.class)
    public ResponseEntity<Object> entityExistsException(EntityExistsException1 entityExistsException1) {
        AppResponse appResponse = new AppResponse(HttpStatus.BAD_REQUEST.value(), false, entityExistsException1.getErrorMessage());
        return new ResponseEntity<Object>(appResponse, HttpStatus.BAD_REQUEST);

    }

    @ExceptionHandler(EntityNotExistsException.class)
    public ResponseEntity<Object> entityNotExistsException(EntityNotExistsException entityNotExistsException) {
        AppResponse appResponse = new AppResponse(HttpStatus.BAD_REQUEST.value(), false, entityNotExistsException.getErrorMessage());
        return new ResponseEntity<Object>(appResponse, HttpStatus.BAD_REQUEST);

    }
}