package org.example.config.streamEnv;


import io.github.cdimascio.dotenv.*;

public class EnvAppConfig implements EnvApp {
    private  Dotenv dotenv = Dotenv.load();

    @Override
    public String topic() {
        return dotenv.get("USER_TOPIC");
    }

    @Override
    public String appIdConfig() {
        return dotenv.get("APPLICATION_ID_CONFIG");
    }

    @Override
    public String bootstrapServerHost() {
        return dotenv.get("BOOTSTRAP_SERVERS_HOST");
    }

    @Override
    public String bootstrapServerPort() {
        return dotenv.get("BOOTSTRAP_SERVERS_PORT");
    }

    @Override
    public String serdeKey() {
        return dotenv.get("SERDE_KEY");
    }

    @Override
    public String serdeValue() {
        return dotenv.get("SERDE_VALUE");
    }
}
