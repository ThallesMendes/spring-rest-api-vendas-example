package com.smn.apivendas.interceptors;

import com.smn.apivendas.exceptions.NotFoundVendaException;
import com.smn.apivendas.models.Venda;
import com.smn.apivendas.services.VendaServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerMapping;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

public class VendaItemVerifyInterceptor extends HandlerInterceptorAdapter {

    @Autowired
    private VendaServiceImpl vendaService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        final Map<String, String> pathVariables = (Map<String, String>) request.getAttribute(HandlerMapping.URI_TEMPLATE_VARIABLES_ATTRIBUTE);

        Venda venda = vendaService.find(Long.valueOf(pathVariables.get("id")));

        if(venda == null){
            throw new NotFoundVendaException();
        }

        return true;
    }
}
