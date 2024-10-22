package ru.nikita.naujava.exceptions;

public class CustomException{
    private String message;

    private CustomException(String message) {
        this.message = "Custom exception: " + message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public static CustomException create(Throwable e) {
        return new CustomException(e.getMessage());
    }

    public static CustomException create(String message) {
        return new CustomException(message);
    }
}