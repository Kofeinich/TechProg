package ru.exception;

public class ItemAlreadyExistsException extends Exception{
    public ItemAlreadyExistsException(String e) {
        super(e);
        this.e = e;
    }
    String e;
}
