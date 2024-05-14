package com.green.gramextra.common;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.resource.PathResourceResolver;

import java.io.IOException;

@Configuration
@Slf4j
public class WebMvc implements WebMvcConfigurer {
    private final String uploadPath;

    public WebMvc(@Value("${file.dir}") String uploadPath){
        this.uploadPath = uploadPath;
    }

    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/pic/**")
                .addResourceLocations("file:" + uploadPath);
        registry.addResourceHandler("/**").
                addResourceLocations("classpath:/static/**").
                resourceChain(true).
                addResolver(new PathResourceResolver(){
                   @Override
                   protected Resource getResource(String resourcePath, Resource location) throws IOException {
                       Resource requestResource = location.createRelative(resourcePath);

                       if(requestResource.exists() && requestResource.isReadable()){
                           return requestResource;
                       }
                       return new ClassPathResource("/static/index.html");
                   }
                });
    }
}
