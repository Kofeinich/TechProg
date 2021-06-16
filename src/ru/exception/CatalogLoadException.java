package ru.exception;

import java.io.FileNotFoundException;

public class CatalogLoadException extends Exception{
    public CatalogLoadException(Exception ex) {
        super(ex);
    }
}