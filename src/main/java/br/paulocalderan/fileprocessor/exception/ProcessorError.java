package br.paulocalderan.fileprocessor.exception;

import org.springframework.http.HttpStatus;

public class ProcessorError extends ApiException {

    public ProcessorError(String message) {
        super(message, HttpStatus.NOT_ACCEPTABLE);
    }
}
