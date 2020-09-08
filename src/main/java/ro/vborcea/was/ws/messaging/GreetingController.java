package ro.vborcea.was.ws.messaging;

import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import ro.vborcea.was.ws.Application;

@Controller
public class GreetingController {

    @MessageMapping("/hello")
    @SendTo("/topic/greetings")
    public Content content(HelloMessage message, @Header("simpSessionId") String sessionId) {
        Application.WS_MAPPING.put(sessionId, message.getName());
        return new Content("Hello, " + message.getName() + "!");
    }
}
