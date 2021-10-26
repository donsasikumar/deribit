package com.test.www.deribit.response;

public class NotFoundException
        extends RuntimeException {
    public NotFoundException(String errorMessage) {
        super(errorMessage);
    }
}
