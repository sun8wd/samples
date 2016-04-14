package com.celloud.websocket;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.shiro.SecurityUtils;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.http.server.ServletServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.server.support.HttpSessionHandshakeInterceptor;
@Component
public class MyHandshakeInterceptor extends HttpSessionHandshakeInterceptor {
    @Override
    public boolean beforeHandshake(ServerHttpRequest request, ServerHttpResponse response, WebSocketHandler handler,
            Map<String, Object> map) throws Exception {
        if (request instanceof ServletServerHttpRequest) {
            ServletServerHttpRequest servletRequest = (ServletServerHttpRequest) request;
            HttpSession session = servletRequest.getServletRequest().getSession(false);
            if (session != null) {
                System.out.println("ok");
                String username = (String) SecurityUtils.getSubject().getPrincipal();
                map.put("username", username);
            }
        }
        return true;
    }
}
