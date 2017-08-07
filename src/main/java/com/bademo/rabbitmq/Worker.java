package com.bademo.rabbitmq;

import com.rabbitmq.client.*;

import java.io.IOException;

/**
 * Created by：rabbitmq练习
 * 工作队列-在工作中分配任务（竞争消费者模式）
 * 消息消费者 - NewTask消息生产者
 * @author Bin.l
 * @date 2017/8/7 21:30
 */
public class Worker {

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
        System.out.println(" [*] Waiting for messages. To exit press CTRL+C");

        channel.basicQos(1); //设置限速,在多个消费者共享一个队列的案例中，明确指定在收到下一个确认回执前每个消费者一次可以接受多少条消息
        final Consumer consumer = new DefaultConsumer(channel) {    // 定义一个消费者类
            // 当有消息到来则该方法被调用
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                String message =  new String(body,"UTF-8");
                System.out.println(" [x] Received '" + message + "'");
                try {
                    doWork(message);
                } finally {
                    System.out.println(" [x] Done");
                    channel.basicAck(envelope.getDeliveryTag(), false);
                }
            }
        };
        // 把上面new出的消费者注册到channel中
        channel.basicConsume(TASK_QUEUE_NAME,
                false, //将此标志设置为false,打开消息确认
                consumer);
    }

    private static void doWork(String task){
        for(char ch:task.toCharArray()){
            if(ch == '.'){
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        }
    }
}
