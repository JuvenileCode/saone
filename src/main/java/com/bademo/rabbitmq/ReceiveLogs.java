package com.bademo.rabbitmq;

import com.rabbitmq.client.*;

import java.io.IOException;

/**
 * Created by -fanout交换机
 * 发布/订阅-[一次向多个消费者发送消息]
 * 消费者-生产者EnitLog
 * @author Bin.l
 * @date 2017/8/9 21:44
 */
public class ReceiveLogs {

    private static final String EXCHANGE_NAME = "logs";

    public static void main(String[] args) throws Exception {
        //建立到服务器的连接
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        //声明交换器
        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();
        //fanout 交换器-
        channel.exchangeDeclare(EXCHANGE_NAME, "fanout");
        //创建一个非持久，排他，自动删除队列
        String queueName = channel.queueDeclare().getQueue();
        //交换器和队列绑定
        channel.queueBind(queueName, EXCHANGE_NAME, "");
        System.out.println(" [*] Waiting for messages. To exit press CTRL+C");

        Consumer consumer = new DefaultConsumer(channel) {
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                String message = new String(body, "UTF-8");
                System.out.println(" [x] Received '" + message + "'");
            }
        };
        channel.basicConsume(queueName, true, consumer);
    }
}
