package de.jenkins.ms.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen",
    date = "2019-012-10T16:48:08.131+02:00")
@Configuration
public class SwaggerConfig {

  ApiInfo apiInfo() {
    return new ApiInfoBuilder().title("Jenkins demo").description(
        "This is a demo to interact with Jenkins")
        .license("Laura Liparulo").licenseUrl("http://gnulicense.org")
        .termsOfServiceUrl("http://gnulicence.com").version("3.0")
        .contact(new Contact("Laura Liparulo", "http://lauraliparulo.altervista.org", "laura@me.com"))
        .build();
  }

  @Bean
  public Docket customImplementation() {
    return new Docket(DocumentationType.SWAGGER_2).select()
        .apis(
            RequestHandlerSelectors.basePackage("de.jenkins.ms.controller"))
        .build().directModelSubstitute(java.time.LocalDate.class, java.sql.Date.class)
        .directModelSubstitute(java.time.OffsetDateTime.class, java.util.Date.class)
        .apiInfo(apiInfo());
  }

}

