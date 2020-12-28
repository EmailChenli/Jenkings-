package com.eastcom.sc.server;

import com.eastcom.inms.cmdb.data.EnableCMDBInventoryServer;
import com.eastcom.sc.EnableScResourceServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
//import com.eastcom.gt.common.web.controller.GlobalExceptionHandler;

/**
 * @author wuqx
 *
 */
@SpringBootApplication
@EnableScResourceServer
@EnableDiscoveryClient
@EnableCMDBInventoryServer
@EnableFeignClients({"com.eastcom.sc.service","com.eastcom.inms.cmdb.service"})
public class ScResourceServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(ScResourceServerApplication.class , args);
    }
}
