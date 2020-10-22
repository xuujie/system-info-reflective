package com.xujie.system.info;

import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ServerWebExchange;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.Map;

@Service
@Slf4j
public class ClientInfoService {

    private final ClientInfoRepository clientInfoRepository;

    public ClientInfoService(ClientInfoRepository clientInfoRepository) {
        this.clientInfoRepository = clientInfoRepository;
    }

    public ClientInfo info(ServerWebExchange exchange) throws JsonProcessingException {
        ClientInfo clientInfo = new ClientInfo();

        clientInfo.setClientName(clientName(exchange));
        clientInfo.setClientIp(ip(exchange));
        clientInfo.setAccessTime(new Timestamp(System.currentTimeMillis()));
        clientInfoRepository.save(clientInfo);
        return clientInfo;
    }

    public String ip(ServerWebExchange exchange) throws JsonProcessingException {
        return exchange.getRequest().getRemoteAddress().getAddress().getHostAddress();
    }

    public String clientName(ServerWebExchange exchange) throws JsonProcessingException {
        return exchange.getRequest().getRemoteAddress().getHostName();
    }
}
