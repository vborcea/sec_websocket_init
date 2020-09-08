package ro.vborcea.was.ws;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.HashMap;
import java.util.Map;

@SpringBootApplication
public class Application {
    public static final Map<String,String> WS_MAPPING = new HashMap<>();

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
