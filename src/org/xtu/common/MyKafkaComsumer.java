package org.xtu.common;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.PartitionInfo;
import org.apache.kafka.common.TopicPartition;

import java.util.*;

/**
 * author:  YuanYingqiu
 * date:    2017/3/15.
 */
public class MyKafkaComsumer implements Runnable {
    private KafkaConsumer<String, String> consumer;
    private String mTopic;
    private String mTable;

    public MyKafkaComsumer(String mTable, String mTopic) {
        this.mTopic = mTopic;
        this.mTable = mTable;
        init();
    }

    private void init() {
        Properties props = new Properties();
        props.put("bootstrap.servers", "192.168.2.50:9092");
        props.put("zookeeper.connect","192.168.2.50:2181/kafka");
//        props.put("group.id", mTable);
        props.put("enable.auto.commit", "true");        //本例使用自动提交位移
        props.put("auto.commit.interval.ms", "1000");
        props.put("session.timeout.ms", "30000");
        props.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        props.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        this.consumer = new KafkaConsumer<>(props);

        List<TopicPartition> list = new ArrayList<>();
        List<PartitionInfo> internets = consumer.partitionsFor(mTopic);
        for (PartitionInfo info : internets) {
            list.add(new TopicPartition(mTopic, info.partition()));
        }

        if (mTopic.equals(MyLog.defaultTopic)) {
            List<PartitionInfo> internetDownload = consumer.partitionsFor(MyLog.defaultTopic);
            for (PartitionInfo info : internetDownload) {
                list.add(new TopicPartition(MyLog.defaultTopic, info.partition()));
            }
        }
        consumer.assign(list);
    }

    public static void main(String[] args) {
    	MyKafkaComsumer instance = new MyKafkaComsumer("comsumerLog","TaxationLog");
    	Thread thread = new Thread(instance);
    	thread.start();
    }


    @Override
    public void run() {
        while (true) {
            try {
                ConsumerRecords<String, String> records = consumer.poll(200);   // 本例使用200ms作为获取超时时间
                int count = 0;
                for (ConsumerRecord<String, String> record : records) {
                    // 这里面写处理消息的逻辑，本例中只是简单地打印消息
                    System.out.println("bububububub:      "+record.value());
                    count++;
                }

                try {
                    Thread.sleep(1000 * 5);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
