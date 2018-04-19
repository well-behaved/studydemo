package demo.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

//@Configuration
//@ComponentScan(basePackages="com.xue.demo.*")
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class},scanBasePackages="com.xue.demo") //不使用数据源
//@EnableAutoConfiguration(exclude = {DataSourceAutoConfiguration.class})
public class Application {
	
    public static void main(String[] args) {
        new SpringApplicationBuilder(Application.class)
                .web(true).run(args);
    }

}
