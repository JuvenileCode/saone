package com.bademo.rabbitmq;

import com.rabbitmq.client.*;

import java.io.IOException;

/**
 * Created by:rabbitmq练习-topic Exchanges
 * 主题-基于模式接收消息（主题）
 * 消息消费 - 生产者EmitLogTopic
 * @author Bin.l
 * @date 2017/8/13 22:02
 */
public class ReceiveLogsTopic {

    private static final String EXCHANGE_NAME = "topic_logs"; //定义一个topic的exchanges

    public static void main(String[] args) throws Exception {
        //建立到服务器的连接
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        //声明交换器
        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();
        //topic 交换器-
        channel.exchangeDeclare(EXCHANGE_NAME, "topic");
        String queueName = channel.queueDeclare().getQueue();
        /*if (args.length < 1) {
            System.err.println("Usage: ReceiveLogsDirect [info] [warning] [error]");
            System.exit(1);
        }*/

        //for (String severity : args) {
        channel.queueBind(queueName, EXCHANGE_NAME, "b.#");
        //}
        System.out.println(" [*] Waiting for messages. To exit press CTRL+C");

        Consumer consumer = new DefaultConsumer(channel) {
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope,
                                       AMQP.BasicProperties properties, byte[] body) throws IOException {
                String message = new String(body, "UTF-8");
                System.out.println(" [x] Received '" + envelope.getRoutingKey() + "':'" + message + "'");
            }
        };
        channel.basicConsume(queueName, true, consumer);
    }

}
