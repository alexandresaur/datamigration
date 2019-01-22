package com.elsevier.datamigration;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableAutoConfiguration
@ComponentScan
@PropertySource({"classpath:swagger.properties"})
public class DataMigrationApplication implements WebMvcConfigurer {

    @Value("#{'${datasearch.webapp}'}")
    public String DATASEARCH_WEBAPP;


    public static void main(String[] args) {
        SpringApplication.run(DataMigrationApplication.class, args);
    }

}

