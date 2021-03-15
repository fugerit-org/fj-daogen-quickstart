package org.fugerit.java.fjdaogenquickstart;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.PathMatchConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class ApiBasePathConfig implements WebMvcConfigurer {
	
    private Logger logger = LoggerFactory.getLogger(getClass());

    private final static String API_PATH = "/jax-rs";
    
    @Override
    public void configurePathMatch(PathMatchConfigurer configurer) {
    	logger.info( "add api path {}", API_PATH );
        configurer.addPathPrefix( API_PATH, (clazz)-> true);
    }
}