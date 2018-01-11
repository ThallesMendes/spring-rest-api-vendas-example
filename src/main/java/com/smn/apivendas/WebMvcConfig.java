package com.smn.apivendas;

import com.smn.apivendas.interceptors.VendaItemVerifyInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

@Configuration
public class WebMvcConfig extends WebMvcConfigurerAdapter {

    @Bean
    VendaItemVerifyInterceptor vendaItemVerifyInterceptor(){
        return new VendaItemVerifyInterceptor();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(vendaItemVerifyInterceptor()).addPathPatterns("/vendas/{id}/itens");
    }
}

