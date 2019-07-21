package massiv_4x4;


public class ArrayException extends RuntimeException {

    private String message;

    public ArrayException(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "Exception: " + message;
    }
}