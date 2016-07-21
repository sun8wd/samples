package com.celloud.kafka;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;

/**
 * 详细可以参考：https://cwiki.apache.org/confluence/display/KAFKA/Consumer+Group+
 * Example
 * 
 * @author Fung
 *
 */
public class ConsumerDemo {
//    private final ConsumerConnector consumer;
    private final String topic;
    private ExecutorService executor;

    public ConsumerDemo(String a_zookeeper, String a_groupId, String a_topic) {
//        consumer = Consumer.createJavaConsumerConnector(createConsumerConfig(a_zookeeper, a_groupId));
        this.topic = a_topic;
    }

    public void shutdown() {
//        if (consumer != null)
//            consumer.shutdown();
        if (executor != null)
            executor.shutdown();
    }

    public void run(int numThreads) throws InterruptedException, ExecutionException {
//        Map<String, Integer> topicCountMap = new HashMap<String, Integer>();
//        topicCountMap.put(topic, new Integer(numThreads));
//        Map<String, List<KafkaStream<byte[], byte[]>>> consumerMap = consumer.createMessageStreams(topicCountMap);
//        List<KafkaStream<byte[], byte[]>> streams = consumerMap.get(topic);
//        executor = Executors.newFixedThreadPool(numThreads);
//        for (final KafkaStream<byte[], byte[]> stream : streams) {
//            executor.submit(new Runnable() {
//                public void run() {
//                    for (MessageAndMetadata<byte[], byte[]> msgAndMetadata : stream) {
//                        System.out.println(new String(msgAndMetadata.message()));
//                    }
//                }
//            });
//        }
    }

//    private static ConsumerConfig createConsumerConfig(String a_zookeeper, String a_groupId) {
//        Properties props = new Properties();
//        props.put("zookeeper.connect", a_zookeeper);
//        if (a_groupId != null && a_groupId.trim().length() > 0) {
//            props.put("group.id", a_groupId);
//        }
//        props.put("zookeeper.session.timeout.ms", "400");
//        props.put("zookeeper.sync.time.ms", "200");
//        props.put("auto.commit.interval.ms", "1000");
//        props.put("enable.auto.commit", "false");
//        props.put("bootstrap.servers", "localhost:9092");
//
//        return new ConsumerConfig(props);
//    }

    public static void main(String[] arg) throws InterruptedException, ExecutionException {
        String[] args = { "localhost:2181", "a", "test", "10" };
        String zooKeeper = args[0];
        String groupId = args[1];
        String topic = args[2];
        int threads = Integer.parseInt(args[3]);

        ConsumerDemo demo = new ConsumerDemo(zooKeeper, groupId, topic);
        demo.run(threads);

        try {
            Thread.sleep(10000);
        } catch (InterruptedException ie) {

        }
        // demo.shutdown();
    }
}