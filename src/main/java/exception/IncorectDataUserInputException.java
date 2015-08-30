package exception;

public class IncorectDataUserInputException extends Exception {
    public IncorectDataUserInputException() {
    }

    public IncorectDataUserInputException(String message) {
        super(message);
    }

    public IncorectDataUserInputException(String message, Throwable cause) {
        super(message, cause);
    }

    public IncorectDataUserInputException(Throwable cause) {
        super(cause);
    }

    public IncorectDataUserInputException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
