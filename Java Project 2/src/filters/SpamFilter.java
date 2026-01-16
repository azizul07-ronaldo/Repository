package filters;

public class SpamFilter implements ChatFilter {
    private String lastMessage = "";

    @Override
    public boolean filter(String message) {
        if (message.equals(lastMessage)) {
            return true;
        }
        lastMessage = message;
        return false;
    }
}

