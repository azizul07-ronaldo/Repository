package filters;

public class SlangFilter implements ChatFilter {

    @Override
    public boolean filter(String message) {
        return message.toLowerCase().contains("idiot")
                || message.toLowerCase().contains("stupid");
    }
}

