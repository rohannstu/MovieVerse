package org.packages.movieverse.Exceptions;

public class FileExistsException extends RuntimeException{
    public FileExistsException(String message) {
        super(message);
    }
}
