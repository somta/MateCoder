package net.somta.matecoder.web.runner;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class PublicityRunner implements ApplicationRunner {

    @Override
    public void run(ApplicationArguments args){
        System.out.println("-----------------------------------------------------------------------");
        System.out.println("文档地址： http://localhost:8888/swagger-ui/index.html?configUrl=/api-docs/swagger-config ");
        System.out.println("开源不易，前往 https://github.com/somta/MateCoder 点个star吧，这是对作者最大的支持！");
        System.out.println("-----------------------------------------------------------------------");
    }
}
