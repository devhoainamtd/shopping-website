package dev.hoainamtd.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

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
        registry.addResourceHandler("/resources/css/**")
                .addResourceLocations("classpath:/static/css/");
        registry.addResourceHandler("/resources/js/**")
                .addResourceLocations("classpath:/static/js/");
    }


}
