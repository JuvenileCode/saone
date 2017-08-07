package com.bademo.rabbitmq;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.MessageProperties;

import java.util.Scanner;

/**
 * Created by:rabbitmq练习
 * 工作队列-在工作中分配任务（竞争消费者模式）
 * 消息生产者 - Worker消息消费者
 * @author Bin.l
 * @date 2017/8/7 21:22
 */
public class NewTask {

    private static final String TASK_QUEUE_NAME = "task_queue"; //定义一个队列

    public static void main(String[] args) throws Exception {
        //建立到服务器的连接
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        //声明交换器
        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();
        //队列设定
        channel.queueDeclare(TASK_QUEUE_NAME,
                true, // 队列可持久化
                false,// 队列非独占，如果是true则只被一个连接（connection）使用，而且当连接关闭后队列即被删除
                false,// 当最后一个消费者退订后，队列立即删除
                null);
        String message = "第二条消息";
        //交换器和队列绑定
        channel.basicPublish("",// exchangeName, 使用默认exchange，名字有服务器生产
                TASK_QUEUE_NAME,
                MessageProperties.PERSISTENT_TEXT_PLAIN,// 消息的属性， 内容是文本，并可以持久化
                message.getBytes("UTF-8")
        );

        channel.close();
        connection.close();
    }
}
