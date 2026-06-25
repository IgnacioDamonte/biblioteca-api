package com.facultad.biblioteca.exception;
public class ResourceNotFoundException extends RuntimeException {
    public ResourceNotFoundException(String r,Long id){ super(r+" con id "+id+" no fue encontrado/a"); }
}