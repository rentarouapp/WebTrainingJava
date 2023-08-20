import java.util.*;

public class Message {
    public static ArrayList<Message> messageList = new ArrayList<Message>();

    String title;
    String handle;
    String message;
    Date date;

    Message(String title, String handle, String message) {
        this.title = title;
        this.handle = handle;
        this.message = message;
        this.date = new Date();
    }
}