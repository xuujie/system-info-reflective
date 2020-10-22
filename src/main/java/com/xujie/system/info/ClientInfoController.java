package com.xujie.system.info;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Flux;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/client")
public class ClientInfoController {

    Logger logger = LoggerFactory.getLogger(getClass());

    private final ClientInfoService clientInfoService;

    public ClientInfoController(ClientInfoService clientInfoService) {
        this.clientInfoService = clientInfoService;
    }

    @GetMapping(produces = "application/json")
    public Flux<ClientInfo> client(ServerWebExchange exchange) throws JsonProcessingException {
        ClientInfo clientInfo= clientInfoService.info(exchange);
        logger.info("client info: {}", JsonConverter.toJson(clientInfo));
        return Flux.just(clientInfo);
    }

//    @GetMapping(value = "/ip", produces = "application/json")
//    public Flux<Map<String, String>> ip(ServerWebExchange exchange) throws JsonProcessingException {
//        return Flux.just(clientInfoService.ip(exchange));
//    }
//
//    @GetMapping(value = "/name", produces = "application/json")
//    public Flux<Map<String, String>> clientName(ServerWebExchange exchange) throws JsonProcessingException {
//        return Flux.just(clientInfoService.clientName(exchange));
//    }
}
