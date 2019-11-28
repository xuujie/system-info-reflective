package com.xujie.system.info;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

import java.net.Inet4Address;
import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/server")
public class ServerInfoController {

    Logger logger = LoggerFactory.getLogger(getClass());
    private final ServerInfoService serverInfoService;

    public ServerInfoController(ServerInfoService serverInfoService) {
        this.serverInfoService = serverInfoService;
    }

    @GetMapping(produces = "application/json")
    public Flux<Map<String, String>> server() throws UnknownHostException, JsonProcessingException {
        Map<String, String> map = new HashMap<>();
        map.putAll(serverInfoService.ip());
        map.putAll(serverInfoService.hostName());
        map.putAll(serverInfoService.os());
        logger.info("server info: {}", JsonConverter.toJson(map));
        return Flux.just(map);
    }

    @GetMapping(value = "/ip", produces = "application/json")
    public Flux<Map<String, String>> ip() throws UnknownHostException, JsonProcessingException {
        return Flux.just(serverInfoService.ip());
    }

    @GetMapping(value = "/host-name", produces = "application/json")
    public Flux<Map<String, String>> hostName() throws UnknownHostException, JsonProcessingException {
        return Flux.just(serverInfoService.hostName());
    }

    @GetMapping(value = "/os", produces = "application/json")
    public Flux<Map<String, String>> os() throws JsonProcessingException {
        return Flux.just(serverInfoService.os());
    }
}
