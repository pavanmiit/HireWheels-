package exceptions;

public class InsufficientBalenc extends Exception{

    public InsufficientBalenc(String insufficient_balence) {
        super(insufficient_balence);
    }
}
