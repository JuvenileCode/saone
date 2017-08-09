package com.bademo.rabbitmq;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

/**
 * Created by:rabbitmq练习-fanout交换机
 * 发布/订阅-[一次向多个消费者发送消息]
 * 消息生产 - 消费者ReceiveLogs
 * @author Bin.l
 * @date 2017/8/9 21:32
 */
public class EmitLog {

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
        String message = "The most important";
        channel.basicPublish(EXCHANGE_NAME, "", null, message.getBytes());
        System.out.println(" [x] sent '" + message + "'");
        channel.close();
        connection.close();
    }
}
