package boat.exception;

public class BoatAlreadyHasADockException extends RuntimeException {

    public BoatAlreadyHasADockException() {
    }

    public BoatAlreadyHasADockException(String message) {
        super(message);
    }
}
