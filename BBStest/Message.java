package bbs;
import java.util.*;

public class Message {
    public static ArrayList<Message> messageList = new ArrayList<Message>();

    public String title;
    public String handle;
    public String message;
    public Date date;

    public Message(String title, String handle, String message) {
        this.title = title;
        this.handle = handle;
        this.message = message;
        this.date = new Date();
    }
}