package com.dbs.banking.poc.bankingdemo.dto;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;

public class ResponseDTO extends ResponseEntity<String> {
    public ResponseDTO(HttpStatus status) {
        super(status);
    }

    public ResponseDTO(String body, HttpStatus status) {
        super(body, status);
    }

    public ResponseDTO(MultiValueMap<String, String> headers, HttpStatus status) {
        super(headers, status);
    }

    public ResponseDTO(String body, MultiValueMap<String, String> headers, HttpStatus status) {
        super(body, headers, status);
    }
}
