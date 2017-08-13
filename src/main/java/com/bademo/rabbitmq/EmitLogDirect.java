package com.bademo.rabbitmq;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

/**
 * Created by:rabbitmq练习-direct Exchanges
 * 路由[有选择的接收消息]
 * 消息生产 - 消费者ReceiveLogsDirect
 * @author Bin.l
 * @date 2017/8/13 21:02
 */
public class EmitLogDirect {

    private static final String EXCHANGE_NAME = "direct_logs"; //定义一个direct的exchanges

    public static void main(String[] args) throws Exception {
        //建立到服务器的连接
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        //声明交换器
        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();
        //direct 交换器-
        channel.exchangeDeclare(EXCHANGE_NAME, "direct");

        String severity = "info";
        String message = "你TM给老子挖这么大一个坑";

        channel.basicPublish(EXCHANGE_NAME, severity, null, message.getBytes());
        System.out.println(" [x] Sent '" + severity + "':'" + message + "'");

        channel.close();
        connection.close();

    }

}
