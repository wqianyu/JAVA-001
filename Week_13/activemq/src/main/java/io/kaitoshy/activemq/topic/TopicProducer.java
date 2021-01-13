package io.kaitoshy.activemq.topic;

import io.kaitoshy.activemq.config.ConstantProperties;
import lombok.extern.slf4j.Slf4j;
import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

@Slf4j
public class TopicProducer {
    public static void main(String[] args) throws JMSException {
        ConnectionFactory connectionFactory = new ActiveMQConnectionFactory(ConstantProperties.BROKER_URL);

        Connection connection = connectionFactory.createConnection();

        connection.start();

        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);

        Destination destination = session.createTopic(ConstantProperties.TOPIC_NAME);

        MessageProducer producer = session.createProducer(destination);

        for (int i = 0; i < 100; i++) {
            TextMessage message = session.createTextMessage("test_" + i);
            producer.send(message);
            log.info(">==== send message:{}", message.getText());
        }

        connection.close();
    }
}
