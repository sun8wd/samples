package com.celloud.action;

import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.celloud.websocket.ChatMessage;
import com.celloud.websocket.ChatService;
import com.celloud.websocket.SystemWebSocketHandler;

@Controller
@RequestMapping("chat")
public class ChatController {
    @RequestMapping("index")
    public String index() {
        return "chat/index";
    }
    @RequestMapping("chats")
    @ResponseBody
    public List<ChatMessage> chats(int id){
        return ChatService.getMessage(id);
    }
    @RequestMapping("users")
    @ResponseBody
    public Set<String> users(){
        return SystemWebSocketHandler.getUsers();
    }
}
