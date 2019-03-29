package Liquid;

/*
 * Wyjątek sygnalizujący błąd procesowania szablonu.
 */
public class LiquidException extends Exception {
    public LiquidException(String errorMessage) {
        super(errorMessage);
    }
}
