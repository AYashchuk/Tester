package exception;

public class NoContainsUserException extends Exception {
    public NoContainsUserException() {
    }

    public NoContainsUserException(String message) {
        super(message);
    }

    public NoContainsUserException(String message, Throwable cause) {
        super(message, cause);
    }

    public NoContainsUserException(Throwable cause) {
        super(cause);
    }

    public NoContainsUserException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
