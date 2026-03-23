package com.thetestingacademy.Utils;
import io.github.cdimascio.dotenv.Dotenv;
public class EnvUtil {
    private static final Dotenv dotenv = Dotenv.configure()
            .ignoreIfMissing()
            .load();
    public static String getUsername() {
        return getRequired("APP_USERNAME");
    }
    public static String getPassword() {
        return getRequired("APP_PASSWORD");
    }
    private static String getRequired(String key) {
        String value = dotenv.get(key);
        if (value == null || value.isBlank()) {
            throw new IllegalStateException("Missing required env variable: " + key);
        }
        return value;
    }
}