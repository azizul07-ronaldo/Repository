package mail;

import enums.Priority;
import model.Mail;
import model.User;

public class MailSender {
    public void sendMail(User sender, User receiver, String content, Priority priority) {
        Mail mail = new Mail(sender.getUsername(), content, priority);
        receiver.addMail(mail);
    }
}
