package boat.exception;

public class BoatNotFoundException extends RuntimeException {
    public BoatNotFoundException() {
    }

    public BoatNotFoundException(String message) {
        super(message);
    }
}
