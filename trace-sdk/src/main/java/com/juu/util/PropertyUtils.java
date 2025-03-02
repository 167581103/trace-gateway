package com.juu.util;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;


@Component
public class PropertyUtils {
    private static String serviceName;

    @Value("${spring.application.name}")
    public void setServiceName(String serviceName) {
        PropertyUtils.serviceName = serviceName;
    }

    public static String getServiceName() {
        return serviceName;
    }
}
