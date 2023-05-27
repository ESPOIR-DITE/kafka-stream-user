package org.example.model;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.apache.kafka.common.serialization.Deserializer;

import java.nio.charset.StandardCharsets;

public class UserDeserializer implements Deserializer<User> {
    private Gson gson =
            new GsonBuilder()
                    .setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE)
                    .create();
    @Override
    public User deserialize(String topic, byte[] data) {
        if (data == null) return null;
        return gson.fromJson(
                new String(data, StandardCharsets.UTF_8), User.class);
    }
}
