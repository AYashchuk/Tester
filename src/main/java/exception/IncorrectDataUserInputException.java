package exception;

public class IncorrectDataUserInputException extends Exception {
    public IncorrectDataUserInputException() {
    }

    public IncorrectDataUserInputException(String message) {
        super(message);
    }

    public IncorrectDataUserInputException(String message, Throwable cause) {
        super(message, cause);
    }

    public IncorrectDataUserInputException(Throwable cause) {
        super(cause);
    }

    public IncorrectDataUserInputException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
