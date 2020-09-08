package ro.vborcea.was.ws.messaging;

public class PublicMessage {

    private String message;

    public PublicMessage() {
    }

    public PublicMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(final String message) {
        this.message = message;
    }
}
