package com.celloud.kafka;

public class SimpleConsumerDemo {
    public static void main(String[] args) {
        new SimpleConsumerDemo().test();
    }

    public void test() {
//        SimpleConsumer consumer = new SimpleConsumer("localhost", 9092, 10000, 1024000, "abc");
        long offset = 0;
        while (true) {
//            Map<TopicAndPartition, PartitionFetchInfo> requestInfo = new HashMap<>();
//            TopicAndPartition tp = new TopicAndPartition("test", 0);
//            PartitionFetchInfo info = new PartitionFetchInfo(offset, 10);
//            requestInfo.put(tp, info);
//            FetchRequest request = new FetchRequest(0, "abc", 12000, 10000, requestInfo);
//            // get the message set from the consumer and print them out
//            FetchResponse response = consumer.fetch(request);
//            ByteBufferMessageSet messages = response.messageSet("test", 0);
//            for (MessageAndOffset msg : messages) {
//                try {
//                    System.out.println("consumed: " + new String(msg.message().payload().array(), "UTF-8"));
//                    System.out.println(offset);
//                } catch (UnsupportedEncodingException e) {
//                    e.printStackTrace();
//                }
//                offset = msg.offset();
//            }
        }
    }
}
