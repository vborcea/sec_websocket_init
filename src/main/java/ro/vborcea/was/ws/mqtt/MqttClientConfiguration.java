package ro.vborcea.was.ws.mqtt;

import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MqttClientConfiguration {

    @Bean
    public MqttClient mqttClientFactory() throws MqttException {
        MqttClient mqttClient = new MqttClient("tcp://localhost:1883", "vborcea", new MemoryPersistence());
        MqttConnectOptions mqttConnectOptions = new MqttConnectOptions();
        mqttConnectOptions.setAutomaticReconnect(true);
        mqttConnectOptions.setUserName("gtbciztk");
        mqttConnectOptions.setPassword("i7gBalNmd3OV".toCharArray());
        mqttConnectOptions.setCleanSession(false);
        mqttConnectOptions.setMqttVersion(4);
        mqttConnectOptions.setKeepAliveInterval(15000);
        mqttClient.connectWithResult(mqttConnectOptions);
        return mqttClient;
    }
}
