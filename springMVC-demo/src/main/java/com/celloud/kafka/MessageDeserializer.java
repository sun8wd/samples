package com.celloud.kafka;

import java.util.Map;

import org.apache.kafka.common.serialization.Deserializer;

import com.celloud.model.User;

public class MessageDeserializer implements Deserializer<User>{

    @Override
    public void configure(Map<String, ?> configs, boolean isKey) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public User deserialize(String topic, byte[] data) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void close() {
        // TODO Auto-generated method stub
        
    }

}
