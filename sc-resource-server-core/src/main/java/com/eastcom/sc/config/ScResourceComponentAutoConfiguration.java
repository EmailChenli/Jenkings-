package com.eastcom.sc.config;

import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.eastcom.sc.EnableScResourceServer;

@Configuration
@ConditionalOnBean(annotation = EnableScResourceServer.class)
@ComponentScan({"com.eastcom.sc","com.eastcom.inms.cmdb.data"})
@EntityScan({"com.eastcom.sc.domain","com.eastcom.inms.cmdb.data.domain"})
@EnableJpaRepositories(basePackages = {"com.eastcom.sc.repository","com.eastcom.inms.cmdb.data.repository"},
        repositoryBaseClass = com.eastcom.gt.data.jpa.repository.GenericJpaRepositoryImpl.class)
@EnableTransactionManagement
public class ScResourceComponentAutoConfiguration {
}
