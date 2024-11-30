package br.paulocalderan.fileprocessor.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import static br.paulocalderan.fileprocessor.exception.ExceptionConstants.UPLOAD_ERROR;
import static org.springframework.http.HttpStatus.BAD_REQUEST;

@ControllerAdvice
public class CustomExceptionHandler extends ResponseEntityExceptionHandler {

    @ResponseBody
    @ExceptionHandler(ProcessorError.class)
    public ResponseEntity<ResponseError> handleApiException(ApiException ex) {
        ResponseError error = new ResponseError(ex.getMessage());
        return new ResponseEntity<>(error, ex.getStatus());
    }

    @ResponseBody
    @ExceptionHandler(MultipartException.class)
    public ResponseEntity<ResponseError> handleMultipartException() {
        ResponseError error = new ResponseError(UPLOAD_ERROR);
        return new ResponseEntity<>(error, BAD_REQUEST);
    }

}
