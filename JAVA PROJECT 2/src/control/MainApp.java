package control;

import model.User;

public class MainApp {
    public static void main(String[] args) {

        User azizul = new User("Azizul");
        User nafees = new User("Nafees");

        CommandProcessor processor = new CommandProcessor();
        processor.process(azizul, nafees);
    }

    private record User(String nafees) {
    }
}

