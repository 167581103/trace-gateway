package com.juu.filter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

@Component
@Slf4j
public class CachedFilter implements GlobalFilter, Ordered {
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        log.info("reqPATH:{}",exchange.getRequest().getPath());
        log.info("reqMETHOD:{}",exchange.getRequest().getMethod());
        log.info("reqHEADER:{}",exchange.getRequest().getHeaders());
        log.info("reqBODY:{}",exchange.getRequest().getBody());
        log.info("缓存通过，放行请求");
        // 请求放行
        return chain.filter(exchange);
    }

    @Override
    public int getOrder() {
        return 0;
    }
}
