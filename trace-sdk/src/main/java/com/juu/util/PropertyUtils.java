package com.juu.util;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;

public class PropertyUtils {
    @Getter
    @Value("${spring.application.name}")
    private static String serviceName;
}
