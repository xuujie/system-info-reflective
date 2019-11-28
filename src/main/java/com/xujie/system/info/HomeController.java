package com.xujie.system.info;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

import java.util.HashMap;
import java.util.Map;

@RestController
public class HomeController {
    Logger logger = LoggerFactory.getLogger(getClass());

    @GetMapping("/")
    public Flux<Map<String, Object>> home() {
        Map<String, Object> map = new HashMap<>();
        map.put("name", "system-info");
        map.put("description", "simple application showing system information");
        Map<String, String> endpointMap = new HashMap<>();
        endpointMap.put("server", "/server");
        endpointMap.put("client", "/client");
        endpointMap.put("actuator", "/actuator");
        map.put("endpoints", endpointMap);
        logger.debug("Request performed");
        return Flux.just(map);
    }
}
