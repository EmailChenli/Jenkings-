package com.eastcom.sc.config;

import com.eastcom.gt.common.web.config.WebMvcConfig;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
//@Import({ResourceServerConfig.class, WebMvcConfig.class})
@Import({WebMvcConfig.class})
public class ScResourceServerConfiguration {
}
