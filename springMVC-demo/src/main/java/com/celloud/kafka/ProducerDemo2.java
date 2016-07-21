package com.celloud.kafka;

import java.util.Date;
import java.util.Properties;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;

import com.celloud.model.User;

public class ProducerDemo2 {
    public static void main(String[] args) {
        producer();
    }

    public static void producer() {
        Properties props = new Properties();
        props.put("bootstrap.servers", "localhost:9092");
        props.put("acks", "all");
        props.put("retries", 0);
        props.put("batch.size", 16384);
        props.put("linger.ms", 1);
        props.put("buffer.memory", 33554432);
        props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        Producer<String, User> producer = new KafkaProducer<>(props);
        for (int i = 0; i < 100; i++) {
            User user = new User();
            user.setId(new Long(i));
            user.setName("孙文栋");
            user.setBirthday(new Date());
            user.setDisabled(false);
            user.setHeight(186.0);
            producer.send(new ProducerRecord<String, User>("test", Integer.toString(i), user));
        }

        producer.close();
    }
}
