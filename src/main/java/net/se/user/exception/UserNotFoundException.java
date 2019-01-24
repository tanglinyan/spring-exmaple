package net.se.user.exception;
/**
 * user not found Exception
 * **/
public class UserNotFoundException extends RuntimeException {
    private static final long serialVersionUID = -1212431451407808758L;
    public UserNotFoundException() {
        super();
    }

    public UserNotFoundException(String message) {
        super(message);
    }

    public UserNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public UserNotFoundException(Throwable cause) {
        super(cause);
    }

}
