package com.sleepcoders.valhalla.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.thymeleaf.spring5.SpringTemplateEngine;
import org.thymeleaf.templateresolver.ClassLoaderTemplateResolver;
import org.thymeleaf.templateresolver.ITemplateResolver;

@Configuration
public class TemplateConfiguration {

    @Bean
    public ITemplateResolver thymeleafClassLoaderTemplateResolver(){
        ClassLoaderTemplateResolver classLoaderTemplateResolver = new ClassLoaderTemplateResolver();
        classLoaderTemplateResolver.setPrefix("templates/");
        classLoaderTemplateResolver.setSuffix(".html");
        classLoaderTemplateResolver.setTemplateMode("HTML");
        classLoaderTemplateResolver.setCharacterEncoding("UTF-8");
        return classLoaderTemplateResolver;
    }

    @Bean
    public SpringTemplateEngine thymeleafTemplateEngine(){
        SpringTemplateEngine springTemplateEngine = new SpringTemplateEngine();
        springTemplateEngine.setTemplateResolver(thymeleafClassLoaderTemplateResolver());
        return springTemplateEngine;
    }
}
