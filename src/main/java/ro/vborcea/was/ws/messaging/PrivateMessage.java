package ro.vborcea.was.ws.messaging;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PrivateMessage {

    private String receiver;

    private String message;

    public PrivateMessage() {
    }

    public PrivateMessage(final String message, final String to) {
        this.message = message;
        this.receiver = to;
    }

    public String getMessage() {
        return message;
    }

    public String getTo() {
        return receiver;
    }

    @JsonProperty("receiver")
    public void setReceiver(final String receiver) {
        this.receiver = receiver;
    }

    @JsonProperty("message")
    public void setMessage(final String message) {
        this.message = message;
    }
}
