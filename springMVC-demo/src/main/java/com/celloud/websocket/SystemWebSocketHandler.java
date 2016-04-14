package com.celloud.websocket;

import java.io.IOException;
import java.util.IdentityHashMap;
import java.util.Map;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.PongMessage;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.WebSocketMessage;
import org.springframework.web.socket.WebSocketSession;

@Component
public class SystemWebSocketHandler implements WebSocketHandler {
    private static final Map<String, WebSocketSession> users = new IdentityHashMap<>();
    private static Logger logger = LoggerFactory.getLogger(SystemWebSocketHandler.class);

    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
        String username = (String) session.getAttributes().get("username");
        logger.info("【{}】closed websocket : status = {}", username, status.toString());
        System.out.println("Server:【" + username + "】 closed!");
        users.remove(username);
        sendMessageToUsers(new TextMessage("users"));
    }

    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        String username = (String) session.getAttributes().get("username");
        System.out.println("Server:【" + username + "】 cennected OK!");
        users.put(username, session);
        sendMessageToUsers(new TextMessage("users"));
    }

    @Override
    public void handleMessage(WebSocketSession session, WebSocketMessage<?> message) throws Exception {
        String username = (String) session.getAttributes().get("username");
        if (message instanceof PongMessage) {
            logger.debug("过滤来自{}的心跳消息", username);
            return;
        }
        System.out.println("handleMessage.......:" + message.getPayload());
        try {

            ChatMessage chatMessage = new ChatMessage(username, message.getPayload() + "");
            ChatService.addMessage(chatMessage);
            System.out.println("handleMessage:" + message.getPayload());
            sendMessageToUsers(new TextMessage("chats"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void handleTransportError(WebSocketSession session, Throwable arg1) throws Exception {
        String username = (String) session.getAttributes().get("username");
        if (session.isOpen()) {
            session.close();
        }
        users.remove(username);
        sendMessageToUsers(new TextMessage("users"));
    }

    @Override
    public boolean supportsPartialMessages() {
        return false;
    }

    /**
     * 给所有在线用户发送消息
     * 
     * @param message
     */
    public void sendMessageToUsers(TextMessage message) {
        for (WebSocketSession user : users.values()) {
            if (user.isOpen()) {
                try {
                    user.sendMessage(message);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void sendMessageToUser(String username, TextMessage message) {
        WebSocketSession user = users.get(username);
        try {
            if (user.isOpen()) {
                user.sendMessage(message);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Set<String> getUsers() {
        return users.keySet();
    }

}
