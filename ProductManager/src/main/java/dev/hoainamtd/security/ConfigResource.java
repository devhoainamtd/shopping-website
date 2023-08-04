package dev.hoainamtd.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

@Configuration
@EnableWebMvc
public class ConfigResource implements WebMvcConfigurer {

//    @Bean
//    public ViewResolver viewResolver() {
//        InternalResourceViewResolver bean = new InternalResourceViewResolver();
//        bean.setViewClass(JstlView.class);
//        bean.setPrefix("resources/templates/");
//        bean.setSuffix(".html");
//        return bean;
//
//    }
    @Override
    public void addResourceHandlers (ResourceHandlerRegistry registry) {
//        registry.addResourceHandler("/css/**").addResourceLocations("classpath:/css/");
        //addResourceHandler("/css/**) <=> localhost:8080/abc/abc.css
        //addResourceLocations(""classpath:/css/) <=> src/main/resource/css
        registry.addResourceHandler("/resources/css/**")
                .addResourceLocations("classpath:/static/css/");
        registry.addResourceHandler("/resources/js/**")
                .addResourceLocations("classpath:/static/js/");
    }


}
