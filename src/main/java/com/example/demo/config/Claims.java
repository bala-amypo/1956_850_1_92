package com.example.demo.config;

import java.util.HashMap;
import java.util.Map;

public class Claims {

    private final Map<String, Object> data = new HashMap<>();

    public void put(String key, Object value) {
        data.put(key, value);
    }

    // ✅ REQUIRED: claims.get("username")
    public Object get(String key) {
        return data.get(key);
    }

    // ✅ REQUIRED: claims.get("username", String.class)
    public <T> T get(String key, Class<T> requiredType) {
        Object value = data.get(key);
        if (value == null) {
            return null;
        }
        return requiredType.cast(value);
    }

    // ✅ REQUIRED: claims.get("username","username",String.class)
    public <T> T get(String key, String defaultKey, Class<T> requiredType) {
        Object value = data.get(key);
        if (value == null) {
            value = data.get(defaultKey);
        }
        if (value == null) {
            return null;
        }
        return requiredType.cast(value);
    }
}
