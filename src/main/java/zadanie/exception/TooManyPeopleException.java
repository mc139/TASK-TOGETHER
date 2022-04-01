package zadanie.exception;

public class TooManyPeopleException extends RuntimeException {

    public TooManyPeopleException() {
    }

    public TooManyPeopleException(String message) {
        super(message);
    }

}
