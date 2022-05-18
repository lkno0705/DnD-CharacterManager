package exceptions;

public class HitDieException extends Exception{

    public HitDieException() {
    }

    public HitDieException(String message) {
        super(message);
    }
}
