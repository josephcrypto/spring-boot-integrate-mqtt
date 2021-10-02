package cn.coding.com.springbootintegratemqtt.core;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties("mqtt")
@Getter
@Setter
public class MqttConfig {

    @Autowired
    private MqttPushClient mqttPushClient;


    private String username;


    private String password;


    private String hostUrl;


    private String clientID;


    private String defaultTopic;


    private int timeout;


    private int keepalive;


    @Bean
    public MqttPushClient getMqttPushClient() {
        System.out.println("hostUrl: " + hostUrl);
        System.out.println("clientId: " + clientID);
        System.out.println("username: " + username);
        System.out.println("password: " + password);
        System.out.println("timeout: " + timeout);
        System.out.println("keepalive: " + keepalive);

        mqttPushClient.connect(hostUrl, clientID, username, password, timeout, keepalive);
        // End with / / to subscribe to all topics starting with test
        mqttPushClient.subscribe(defaultTopic, 2);
        return mqttPushClient;
    }
}
