package com.bademo.rabbitmq;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

/**
 * Created by:rabbitmq练习-topic Exchanges
 * 主题-基于模式接收消息（主题）
 * 消息生产 - 消费者ReceiveLogsTopic
 * @author Bin.l
 * @date 2017/8/13 21:56
 */
public class EmitLogTopic {

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

        String severity = "b.a.b.c";
        String message = "topic exchanges 练习";

        channel.basicPublish(EXCHANGE_NAME, severity, null, message.getBytes());
        System.out.println(" [x] Sent '" + severity + "':'" + message + "'");

        channel.close();
        connection.close();
    }
}
