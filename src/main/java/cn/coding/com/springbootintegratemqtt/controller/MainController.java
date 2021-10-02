package cn.coding.com.springbootintegratemqtt.controller;

import cn.coding.com.springbootintegratemqtt.core.MqttPushClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class MainController {

    @Autowired
    private MqttPushClient mqttPushClient;

    @GetMapping(value = "/publishTopic")
    public String publishTopic() {
        String topicString = "mqttProducer";
        mqttPushClient.publish(2, false, topicString, "This Message is my testing passing through successfully!!!!");
        return "Success";
    }

    //Send custom message content (using default theme)
    @RequestMapping("/publishTopic/{data}")
    public String test1(@PathVariable String data) {
        String topicString = "mqttProducer";
        mqttPushClient.publish(2, false, topicString, data);
        return "Success";
    }

    //Send custom message content and specify subject
    @RequestMapping("/publishTopic/{topic}/{data}")
    public String test2(@PathVariable String topic, @PathVariable String data) {
        mqttPushClient.publish(2, false, topic, data);
        return "Success";
    }
}
