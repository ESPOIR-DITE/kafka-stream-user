package org.example.util;


import org.apache.kafka.streams.KafkaStreams;
import org.apache.kafka.common.serialization.Serdes;
import org.apache.kafka.streams.StreamsConfig;
import org.example.config.AppProperties;

import java.util.Properties;

public class AppUtils {
    public static Properties getProperties(AppProperties appProperties){
        Properties properties = new Properties();
        properties.put(StreamsConfig.APPLICATION_ID_CONFIG, appProperties.appIdConfig());
        properties.put(StreamsConfig.BOOTSTRAP_SERVERS_CONFIG, appProperties.bootstrapServerHost()+":"+appProperties.bootstrapServerPort());
        properties.put(StreamsConfig.DEFAULT_KEY_SERDE_CLASS_CONFIG, Serdes.Void().getClass().getName());
        properties.put(StreamsConfig.DEFAULT_VALUE_SERDE_CLASS_CONFIG, Serdes.String().getClass().getName());
        return properties;
    }
}
