package com.mybank.configuration;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
@EnableWebMvc
public class Staticresources extends WebMvcConfigurerAdapter{

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/public/images/**")
                .addResourceLocations("file:///D:/Java/angular/myBankwithAngular/img/" );
        registry.addResourceHandler("/**")
                .addResourceLocations("classpath:/META-INF/resources/"
                        ,"classpath:/static",
                        "classpath:/resources",
                        "classpath:/public");
    }
}
