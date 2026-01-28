package model;
import java.util.ArrayList;
import java.util.List;

public class User {
    private final String username;
    private final List<Mail> inbox;
    private int spamScore;

    public User(String username) {
        this.username = username;
        this.inbox = new ArrayList<>();
        this.spamScore = 0;
    }

    public String getUsername() {
        return username;
    }

    public List<Mail> getInbox() {
        return inbox;
    }

    public void addMail(Mail mail) {
        inbox.add(mail);
    }

    public void increaseSpamScore() {
        spamScore++;
    }

    public boolean isMuted() {
        return spamScore > 5;
    }
}
