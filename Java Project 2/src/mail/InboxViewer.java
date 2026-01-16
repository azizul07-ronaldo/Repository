package mail;

import enums.Priority;
import model.Mail;
import model.User;

import java.util.Comparator;

public class InboxViewer {

    public void readInbox(User user) {
        user.getInbox().stream()
                .sorted(Comparator
                        .comparing(Mail::getPriority).reversed()
                        .thenComparing(Mail::getTimestamp))
                .forEach(mail -> {
                    String mark = mail.getPriority() == Priority.URGENT ? "[!]" : "[ ]";
                    System.out.println(mark + " " + mail.getPriority()
                            + ": \"" + mail.getContent()
                            + "\" (from " + mail.getSender() + ")");
                });
    }
}

