package ro.vborcea.was.ws.messaging;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import ro.vborcea.was.ws.Application;

@Controller
public class PrivateMessageController {

    @Autowired
    private SimpMessagingTemplate webSocket;

    @MessageMapping("/privateMessage")
    @SendTo("/topic/privateMessage/{simpSessionId}")
    public void privateMessaging(final PrivateMessage message, final @Header("simpSessionId") String sessionId) {
        final String sender = Application.WS_MAPPING.get(sessionId);
        webSocket
                .convertAndSend("/topic/privateMessage/" + message.getTo(), sender + ": " + message.getMessage());
        webSocket
                .convertAndSend("/topic/privateMessage/" + Application.WS_MAPPING.get(sessionId), sender + ": @" + message.getTo() + ": " + message.getMessage());
    }
}
