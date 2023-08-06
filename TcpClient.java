import java.io.*;
import java.net.*;

public class TcpClient {
    public static void main(String[] args) throws Exception {
        try (Socket socket = new Socket("localhost", 80);
            FileInputStream fis = new FileInputStream("client_send.txt");
            FileOutputStream fos = new FileOutputStream("client_recv.txt")) {
                
                int ch;
                // client_send.txtの内容をサーバに送信
                OutputStream output = socket.getOutputStream();
                while ((ch = fis.read()) != -1) {
                    output.write(ch);
                }
                // 終了を示すために0を送信
                //output.write(0);
                // サーバからの返信をclient_recv.txtに出力
                InputStream input = socket.getInputStream();
                while ((ch = input.read()) != -1) {
                    fos.write(ch);
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
    }
}