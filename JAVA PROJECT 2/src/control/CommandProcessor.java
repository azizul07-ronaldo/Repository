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
    private final ChatRoom chatRoom = new ChatRoom();
    private final MailSender mailSender = new MailSender();
    private final InboxViewer inboxViewer = new InboxViewer();

    public void process(User user1, User user2) {
        Scanner sc = new Scanner(System.in);
        User currentUser = user1;

        while (true) {
            System.out.println("\nCurrent User: " + currentUser.getUsername());
            System.out.println("Commands(Send / Mail / Read / Switch / Exit): ");
            String command = sc.nextLine();

            if (command.equalsIgnoreCase("Send")) {
                System.out.print("Message: ");
                chatHandler.handleMessage(currentUser, sc.nextLine(), chatRoom);
            }

            else if (command.equalsIgnoreCase("Mail")) {
                User receiver = currentUser == user1 ? user2 : user1;

                System.out.print("Priority (LOW/NORMAL/URGENT): ");
                Priority p = Priority.valueOf(sc.nextLine().toUpperCase());

                System.out.print("Content: ");
                mailSender.sendMail(currentUser, receiver, sc.nextLine(), p);
                System.out.println("Mail sent to " + receiver.getUsername());
            }

            else if (command.equalsIgnoreCase("Read")) {
                inboxViewer.readInbox(currentUser);
            }

            else if (command.equalsIgnoreCase("Switch")) {
                currentUser = (currentUser == user1) ? user2 : user1;
                System.out.println("Switched user.");
            }

            else if (command.equalsIgnoreCase("Exit")) {
                break;
            }
        }
    }
}
