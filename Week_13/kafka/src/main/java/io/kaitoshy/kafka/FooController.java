package io.kaitoshy.kafka;

import io.kaitoshy.kafka.common.Foo1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FooController {
    @Autowired
    private KafkaTemplate<Object, Object> kafkaTemplate;

    @PostMapping("/send/foo/{what}")
    public void sendFoo(@PathVariable String what) {
        kafkaTemplate.send("topic1", new Foo1(what));
    }
}
