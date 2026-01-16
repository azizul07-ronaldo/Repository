package filters;

public class AdFilter implements ChatFilter {

    @Override
    public boolean filter(String message) {
        return message.contains(".com")
                || message.contains("http")
                || message.contains("www");
    }
}

