package com.smn.apivendas.controllers;

import com.smn.apivendas.ApiVendasApplication;
import com.smn.apivendas.contracts.Message;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class IndexController {

    @ApiOperation(value = "Inicio API")
    @GetMapping
    @ResponseBody
    private ResponseEntity<Message> index(){

        Logger logger = LogManager.getLogger(ApiVendasApplication.class);

        logger.debug("DEBUG MESSAGE");
        logger.info("INFO MESSAGE");
        logger.warn("WARN MESSAGE");
        logger.error("ERROR MESSAGE");
        logger.fatal("FATAL MESSAGE");

        return new ResponseEntity<Message>(new Message("API Rest de Vendas - por Thalles Mendes - ver 1.0"), HttpStatus.OK);
    }

}
