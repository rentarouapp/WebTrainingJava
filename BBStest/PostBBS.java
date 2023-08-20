import java.io.*;
import javax.servlet.http.*;

public class PostBBS extends HttpServlet {
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException, IOException {
        request.setCharacterEncoding("UTF-8");
        Message newMessage = new Message(request.getParameter("title"), request.getParameter("handle"), request.getParameter("message"));
        Message.messageList.add(0, newMessage);
        response.sendRedirect("/testbbs/ShowBBS");
    }
}