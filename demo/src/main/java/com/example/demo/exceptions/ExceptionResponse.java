package com.example.demo.exceptions;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@AllArgsConstructor
@Data
public class ExceptionResponse implements Serializable {

    private static final long serialVersion = 1;

    private Date timestamp;
    private String message;
    private String details;

}
