package control;

import chat.ChatHandler;
import chat.ChatRoom;
import enums.Priority;
import mail.InboxViewer;
import mail.MailSender;
import model.User;

import java.util.Scanner;

public class CommandProcessor {
    private final ChatHandler chatHandler = new ChatHandler();
    private final ChatRoom chatRoom;
    private final MailSender mailSender;
    private final InboxViewer inboxViewer;

    public CommandProcessor() {
        chatRoom = new ChatRoom();
        mailSender = new MailSender();
        inboxViewer = new InboxViewer();
    }

    public void process(User currentUser, User otherUser) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\nEnter command (Send / Mail / Read / Exit): ");
            String command = sc.nextLine();

            if (command.equalsIgnoreCase("Send")) {
                System.out.print("Message: ");
                String msg = sc.nextLine();
                chatHandler.handleMessage(currentUser, msg, chatRoom);
            }

            else if (command.equalsIgnoreCase("Mail")) {
                System.out.print("Priority (LOW/NORMAL/URGENT): ");
                Priority p = Priority.valueOf(sc.nextLine().toUpperCase());

                System.out.print("Content: ");
                String content = sc.nextLine();

                mailSender.sendMail(currentUser, otherUser, content, p);
                System.out.println("Mail sent successfully.");
            }

            else if (command.equalsIgnoreCase("Read")) {
                inboxViewer.readInbox(currentUser);
            }

            else if (command.equalsIgnoreCase("Exit")) {
                break;
            }
        }
    }
}

