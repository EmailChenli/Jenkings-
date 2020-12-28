package com.eastcom.sc.config;

import com.eastcom.sc.EnableScResourceServer;
import org.springframework.boot.autoconfigure.AutoConfigureBefore;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.jackson.JacksonAutoConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@AutoConfigureBefore({JacksonAutoConfiguration.class})
@ConditionalOnBean(annotation = EnableScResourceServer.class)
@Import(ScResourceServerConfiguration.class)
public class ScResourceServerAutoConfiguration {
}
