package com.celloud.kafka;

import java.util.Arrays;
import java.util.Properties;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ConsumerDemo2 {
    private static Logger logger = LoggerFactory.getLogger(ConsumerDemo2.class);
    private static KafkaConsumer<String, String> consumer;

    public static void main(String[] args) {
        consumer();
    }

    public static void consumer() {
        Properties props = new Properties();
        props.put("bootstrap.servers", "localhost:9092");
        props.put("group.id", "group-2");
        props.put("enable.auto.commit", "true");
        props.put("fetch.wait.max.ms", "200");
        props.put("auto.commit.interval.ms", "1000");
        props.put("session.timeout.ms", "30000");
        props.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        props.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        consumer = new KafkaConsumer<>(props);
        consumer.subscribe(Arrays.asList("test"));
        while (true) {
            ConsumerRecords<String, String> records = consumer.poll(Long.MAX_VALUE);
            System.out.println("polling...");
            for (ConsumerRecord<String, String> record : records) {
                logger.info("offset = {}, key = {}, value = {}", record.offset(), record.key(), record.value());
            }
        }

    }
}
