package org.xtu.common;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Partitioner;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.Cluster;
import org.apache.kafka.common.serialization.StringSerializer;

import java.util.Map;
import java.util.Properties;

/**
 * Created by wnd on 17/2/28 0028.
 * @author wnd
 */
public class MyKafkaProducer {
    private KafkaProducer<String, String> producer;
    private static Properties prop	= null;

    public void init() {
        prop = new Properties();
        prop.put("serializer.class", "kafka.serializer.StringEncoder");
        // kafka集群包含多台服务器，这里指定的集群服务器的一个子集
        prop.put("zookeeper.connect","192.168.2.50:2181");
        prop.put("bootstrap.servers", "192.168.2.50:9092");
        prop.put("queue.enqueue.timeout.ms", "2000");
        prop.put("partitioner.class", SimplePartitioner.class);

    }

    private static MyKafkaProducer mProducer;
    public static MyKafkaProducer getInstance(){
        if(mProducer == null){
            synchronized (MyKafkaProducer.class){
                if(mProducer == null){
                    mProducer = new MyKafkaProducer();
                }
            }
        }
        return mProducer;
    }
    public MyKafkaProducer() {
        init();
        producer = new KafkaProducer<String, String>(prop,
                new StringSerializer(), new StringSerializer());
    }
    public void send(String topicName, String value) {
        if (topicName == null || value == null) {
            return;
        }
        // 如果具有多个partitions,请使用new KeyedMessage(String topicName,K key,V
        // value).key表示分区名称，value代表具体数据
        // 不指定KEY的话，则随机分配partition
        ProducerRecord<String, String> record = new ProducerRecord<String, String>(topicName,value);
        producer.send(record);
        producer.flush();
    }

    public void send(String topicName, String key, String value) {
        if (topicName == null || value == null) {
            return;
        }
        // 如果具有多个partitions,请使用new KeyedMessage(String topicName,K key,V
        // value).key表示分区名称，value代表具体数据
        // 不指定KEY的话，则随机分配partition
        ProducerRecord<String, String> record = new ProducerRecord<String, String>(topicName, key, value);
        producer.send(record);
    }

    public void close() {
        producer.close();
    }

    public static void main(String args[]) {

    }

    public  static class SimplePartitioner implements Partitioner {

        @Override
        public int partition(String s, Object o, byte[] bytes, Object o1, byte[] bytes1, Cluster cluster) {
            if(o==null)
                return 0;
            int num=o.hashCode();
            if (num%5==0)
                return 0;
            else if (num%5==1)
                return 1;
            else if (num%5==2)
                return 2;
            else if (num%5==3)
                return 4;
            else if (num%5==4)
                return 4;
            else return 0;
        }

        @Override
        public void close() {

        }

        @Override
        public void configure(Map<String, ?> map) {

        }
    }
}

