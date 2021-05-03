package ro.vborcea.was.ws.mqtt;

import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import ro.vborcea.was.ws.Application;

import javax.annotation.PostConstruct;
import java.util.Map;

@RestController
public class MqttController {

    @Autowired
    private SimpMessagingTemplate webSocket;

    @PostConstruct
    public void init() throws MqttException {
        mqttClient.subscribe("/match/+/event", (topic, msg) -> {
            System.out.println("topic: " + topic + " ,message: " + new String(msg.getPayload()));
            System.out.println();

            for (Map.Entry<String, String> entry : Application.WS_MAPPING.entrySet()) {
                webSocket
                        .convertAndSend("/topic/privateMessage/" + entry.getValue(), "event de meci: " + new String(msg.getPayload()));
            }
        });
    }

    @Autowired
    private MqttClient mqttClient;

    @PostMapping("/start")
    public void start() throws MqttException {
        mqttClient.publish("/match/table1/start", new MqttMessage("start".getBytes()));
    }

    @PostMapping("/stop")
    public void stop() throws MqttException {
        mqttClient.publish("/match/table1/stop", new MqttMessage("stop".getBytes()));
    }

    @PostMapping("/pause")
    public void pause() throws MqttException {
        mqttClient.publish("/match/table1/pause", new MqttMessage("pause".getBytes()));
    }

    @PostMapping("/restart")
    public void restart() throws MqttException {
        mqttClient.publish("/match/table1/restart", new MqttMessage("restart".getBytes()));
    }
}
