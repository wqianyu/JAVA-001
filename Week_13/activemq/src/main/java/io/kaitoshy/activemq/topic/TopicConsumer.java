package io.kaitoshy.activemq.topic;

import io.kaitoshy.activemq.config.ConstantProperties;
import lombok.extern.slf4j.Slf4j;
import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

@Slf4j
public class TopicConsumer {
    public static void main(String[] args) throws JMSException {
        ConnectionFactory connectionFactory = new ActiveMQConnectionFactory(ConstantProperties.BROKER_URL);

        Connection connection = connectionFactory.createConnection();

        connection.start();

        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);

        Destination destination = session.createTopic(ConstantProperties.TOPIC_NAME);

        MessageConsumer consumer = session.createConsumer(destination);

        consumer.setMessageListener(message -> {
            TextMessage textMessage = (TextMessage) message;
            try {
                log.info(">======= consumer receive:{}", textMessage.getText());
            } catch (JMSException jmsException) {
                jmsException.printStackTrace();
            }
        });
    }
}
