package pl.agnieszka.model.exception;

/**
 * Created by as on 15.07.2017.
 */

public class NotFoundException extends RuntimeException {

    public static final NotFoundException INVALID_ID = new NotFoundException("Nie ma takiego id");
    public static final NotFoundException EMPTY_ID = new NotFoundException("Puste id");
    public static final NotFoundException EMPTY_KEY = new NotFoundException("Puste słowo kluczowe");
    public static final NotFoundException OTHER_ERROR = new NotFoundException("Inny błąd");

    private String text;

    private NotFoundException(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }
}
