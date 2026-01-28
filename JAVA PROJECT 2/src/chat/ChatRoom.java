package chat;

import java.util.LinkedList;

public class ChatRoom {
    private final LinkedList<String> chatHistory = new LinkedList<>();

    public void addMessage(String message) {
        if (chatHistory.size() == 50) {
            chatHistory.removeFirst();
        }
        chatHistory.add(message);
    }
}

