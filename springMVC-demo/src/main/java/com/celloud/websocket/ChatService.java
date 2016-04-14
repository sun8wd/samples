package com.celloud.websocket;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ChatService {
    private static Map<Integer, ChatMessage> chats = new HashMap<>();
    private static int nextId = 1;

    public static List<ChatMessage> getMessage(int id) {
        List<ChatMessage> messages = new ArrayList<>();
        for (int ids : chats.keySet()) {
            if (ids > id) {
                messages.add(chats.get(ids));
            }
        }
        return messages;
    }

    public static void addMessage(ChatMessage message) {
        System.out.println("message=" + message.getMessage());
        message.setId(nextId);
        chats.put(nextId, message);
        nextId++;
    }
}
