package org.example.model;

import com.google.gson.Gson;
import org.apache.kafka.common.serialization.Serializer;

import java.nio.charset.StandardCharsets;

public class UserSerializer implements Serializer<User> {
    private Gson gson = new Gson();
    @Override
    public byte[] serialize(String topic, User data) {
        if (data == null) return null;
        return gson.toJson(data).getBytes(StandardCharsets.UTF_8);
    }
}
