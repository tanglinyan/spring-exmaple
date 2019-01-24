package net.se.user.exception;

public class PasswordAuthException extends RuntimeException {

    private static final long serialVersionUID = -2134460042115081244L;

    public PasswordAuthException() {
        super();
    }

    public PasswordAuthException(String message) {
        super(message);
    }

    public PasswordAuthException(String message, Throwable cause) {
        super(message, cause);
    }

    public PasswordAuthException(Throwable cause) {
        super(cause);
    }

    protected PasswordAuthException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
