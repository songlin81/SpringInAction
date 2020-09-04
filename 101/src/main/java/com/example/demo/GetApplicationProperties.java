package com.example.demo;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import java.util.List;

@Data
@Component
@ConfigurationProperties(prefix ="com.example")
public class GetApplicationProperties {
    private String section;
    private int sectionNo;
    private List<String> address;
}
