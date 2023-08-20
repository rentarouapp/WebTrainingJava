import java.io.*;
import javax.servlet.http.*;

public class ShowBBS extends HttpServlet {
    // HTMLで意味を持つ文字をエスケープする
    private String escapeHtml(String src) {
        return src.replace("&", "&amp;").replace("<", "&lt;").replace(">", "&gt;").replace("\"", "&quot;").replace("'", "&#39;");
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println("<html>");
        out.println("<head>");
        out.println("<title>テスト掲示板</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>テスト掲示板</h1>");
        out.println("<form action='/testbbs/PostBBS' method='post'>");
        out.println("タイトル：<input type='text' name='title' size='60'>" + "<br/>");
        out.println("ハンドル名：<input type='text' name='handle'><br/>");
        out.println("<textarea name='message' rows='4' cols='60'>コメントを書いてね</textarea><br/>");
        out.println("<input type='submit'/>");
        out.println("</form>");
        out.println("<hr/>");

        for (Message message : Message.messageList) {
            out.println("<p>『" + escapeHtml(message.title) +
            "』&nbsp;&nbsp;" + escapeHtml(message.handle) +
            " さん&nbsp;&nbsp" + escapeHtml(message.date.toString()) + "</p>");

            out.println("<p>");
            out.println(escapeHtml(message.message).replace("\r\n", "<br/>"));
            out.println("</p><hr/>");
       }
       out.println("</body>");
       out.println("</html>");
    }
}