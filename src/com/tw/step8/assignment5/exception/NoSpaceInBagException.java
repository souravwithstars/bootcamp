package com.tw.step8.assignment5.exception;

public class NoSpaceInBagException extends Exception {
    public NoSpaceInBagException(Integer maxSize) {
        super(String.valueOf(maxSize));
    }
}
