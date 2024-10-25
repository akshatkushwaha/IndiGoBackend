package com.challenge.indigobackend.errors;

public class ObjectNotFound extends RuntimeException {
    public ObjectNotFound(String message) {
        super(message);
    }
}
