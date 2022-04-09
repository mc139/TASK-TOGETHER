package boat.exception;

public class TooBigBoatException extends RuntimeException {

    public TooBigBoatException() {
    }

    public TooBigBoatException(String message) {
        super(message);
    }
}
