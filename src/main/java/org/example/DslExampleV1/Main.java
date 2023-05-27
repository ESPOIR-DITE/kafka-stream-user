package org.example.DslExampleV1;

import io.github.cdimascio.dotenv.*;
import org.apache.kafka.common.serialization.Serdes;
import org.apache.kafka.streams.KafkaStreams;
import org.apache.kafka.streams.StreamsBuilder;
import org.apache.kafka.streams.kstream.Consumed;
import org.apache.kafka.streams.kstream.KStream;
import org.example.config.streamEnv.EnvAppConfig;
import org.example.util.AppUtils;

public class Main {
    public static void main(String[] args) {

        // My environment variables.
        EnvAppConfig config = new EnvAppConfig();
        /**
         * We first need to use a Kafka Streams class
         * called StreamsBuilder to build our processor topology.
         */

        StreamsBuilder builder = new StreamsBuilder();

        /**
         * we need to add a source
         * processor in order to read data from a Kafka topic (in this case, our topic will be
         * called users). There are a few different methods we could use here depending on
         * how we decide to model our data (we will discuss different approaches in “Streams
         * and Tables” on page 53), but for now, let’s model our data as a stream. The following
         * line adds the source processor:
         *
         * The generics in KStream<Void,String> refer to the key and value types. In this case, the key is empty (Void) and
         * the value is a String type.
         */

//        KStream<Void, String> stream = builder.stream("users", Consumed.with(Serdes.Void(), Serdes.String()));
        KStream<Void, String> stream = builder.stream("users");

        /**
         * Now, it’s time to add a stream processor. Since we’re just printing a simple greeting for
         * each message, we can use the foreach operator with a simple lambda like so:
         */

        stream.foreach(
                (key, value) -> {
                    System.out.println("(DSL) Hello, " + value);
                });

        /**
         * Finally, it’s time to build our topology and start running our stream processing
         * application:
         */


        KafkaStreams streams = new KafkaStreams(builder.build(), AppUtils.getProperties(config));
        streams.start();
    }
}
