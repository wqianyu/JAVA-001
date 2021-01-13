package io.kaitoshy.activemq.queue;

import io.kaitoshy.activemq.config.ConstantProperties;
import lombok.extern.slf4j.Slf4j;
import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

@Slf4j
public class AppProducer {

    public static void main(String[] args) throws JMSException {
        // 创建 ConnectionFactory
        ConnectionFactory connectionFactory = new ActiveMQConnectionFactory(ConstantProperties.BROKER_URL);
        // 创建连接
        Connection connection = connectionFactory.createConnection();
        // 启动连接
        connection.start();
        // 创建会话
        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        // 创建一个目标
        Destination destination = session.createQueue(ConstantProperties.QUEUE_NAME);

        // 创建一个生产者
        MessageProducer producer = session.createProducer(destination);

        // 创建消息
        for (int i = 0; i < 20; i++) {
            TextMessage textMessage = session.createTextMessage("test_" + i);
            producer.send(textMessage);
            log.info(">==== send message:{}", textMessage.getText());
        }

        // 关闭连接
        connection.close();
    }
}
