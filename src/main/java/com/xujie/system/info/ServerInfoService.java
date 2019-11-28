package com.xujie.system.info;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import java.net.Inet4Address;
import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.Map;

@Service
public class ServerInfoService {
    Logger logger = LoggerFactory.getLogger(getClass());

    public Map<String, String> ip() throws UnknownHostException, JsonProcessingException {
        Map<String, String> map = new HashMap<>();
        String ip = Inet4Address.getLocalHost().getHostAddress();
        map.put("ip", ip);
        logger.info(JsonConverter.toJson(map));
        return map;
    }

    public Map<String, String> hostName() throws UnknownHostException, JsonProcessingException {
        Map<String, String> map = new HashMap<>();
        String hostName = Inet4Address.getLocalHost().getHostName();
        map.put("host-name", hostName);
        String canonicalHostName = Inet4Address.getLocalHost().getCanonicalHostName();
        map.put("canonical-host-name: ", canonicalHostName);
        logger.info(JsonConverter.toJson(map));
        return map;
    }

    public Map<String, String> os() throws JsonProcessingException {
        Map<String, String> map = new HashMap<>();
        String os = System.getProperty("os.name");
        map.put("os", os);
        logger.info(JsonConverter.toJson(map));
        return map;
    }
}
