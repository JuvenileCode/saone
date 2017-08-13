package com.bademo.rabbitmq;

import com.rabbitmq.client.*;

import java.io.IOException;

/**
 * Created by:rabbitmq练习-direct Exchanges
 * 路由[有选择的接收消息]
 * 消息消费 - 消费生产者 EmitLogDirect
 * @author Bin.l
 * @date 2017/8/13 21:14
 */
public class ReceiveLogsDirect {

    private static final String EXCHANGE_NAME = "direct_logs"; //定义一个direct的exchanges

    public static void main(String[] args) throws Exception {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        //声明交换器
        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();
        //fanout 交换器-
        channel.exchangeDeclare(EXCHANGE_NAME, "direct");
        String queueName = channel.queueDeclare().getQueue();

        /*if (args.length < 1) {
            System.err.println("Usage: ReceiveLogsDirect [info] [warning] [error]");
            System.exit(1);
        }*/

        //for (String severity : args) {
            channel.queueBind(queueName, EXCHANGE_NAME, "info");
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

