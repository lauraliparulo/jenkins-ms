package de.jenkins.ms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jmx.JmxAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@ComponentScan
@EnableSwagger2
//@EnableAutoConfiguration(exclude={JmxAutoConfiguration.class})
public class JenkinsDemoApplication {

  public static void main(String[] args) {
    SpringApplication.run(JenkinsDemoApplication.class, args);
  }

}