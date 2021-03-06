package sc.eureka.server;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;


/**
 * @desc:
 * @author: hanchenghai
 * @date: 2018/12/17
 */
@EnableEurekaServer
@SpringBootApplication
@Slf4j
public class EurekaServerApplication {
    public static void main(String[] args) {
        SpringApplication.run(EurekaServerApplication.class, args);
        log.info("eureka server 启动...");
    }
}
