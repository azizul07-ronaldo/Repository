package chat;

import filters.AdFilter;
import filters.ChatFilter;
import filters.SlangFilter;
import filters.SpamFilter;
import model.User;

public class ChatHandler {
    private final ChatFilter[] filters;

    public ChatHandler() {
        filters = new ChatFilter[]{
                new SlangFilter(),
                new AdFilter(),
                new SpamFilter()
        };
    }

    public void handleMessage(User user, String message, ChatRoom room) {
        for (ChatFilter filter : filters) {
            if (filter.filter(message)) {
                System.out.println("[SYSTEM]: Message blocked.");

                if (filter instanceof SpamFilter) {
                    user.increaseSpamScore();
                }
                return;
            }
        }
        room.addMessage(user.getUsername() + ": " + message);
        System.out.println("Message sent successfully.");
    }
}

