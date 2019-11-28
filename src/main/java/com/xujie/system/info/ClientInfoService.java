package com.xujie.system.info;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Flux;

import java.util.HashMap;
import java.util.Map;

@Service
public class ClientInfoService {
    Logger logger = LoggerFactory.getLogger(getClass());

    public Map<String, String> ip(ServerWebExchange exchange) throws JsonProcessingException {
        Map<String, String> map = new HashMap<>();
        String clientIp = exchange.getRequest().getRemoteAddress().getAddress().getHostAddress();
        map.put("ip", clientIp);
        logger.info(JsonConverter.toJson(map));
        return map;
    }

    public Map<String, String> clientName(ServerWebExchange exchange) throws JsonProcessingException {
        Map<String, String> map = new HashMap<>();
        String clientIp = exchange.getRequest().getRemoteAddress().getHostName();
        map.put("name", clientIp);
        logger.info(JsonConverter.toJson(map));
        return map;
    }
}
