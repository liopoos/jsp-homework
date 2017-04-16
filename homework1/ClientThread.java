/**
 * Created by hades on 2017/3/17.
 */

import java.io.*;
import java.net.Socket;

public class ClientThread extends Thread {
    Socket socket = null;

    public ClientThread(Socket socket) {

        this.socket = socket;
    }

    public String echo(String msg) {

        return "返回的消息:" + msg;
    }

    private PrintWriter getWriter(Socket socket) throws IOException {  //输出流的建立
        OutputStream socketOut = socket.getOutputStream();
        return new PrintWriter(socketOut, true);
    }

    private BufferedReader getReader(Socket socket) throws IOException {  //输入流的建立
        InputStream socketIn = socket.getInputStream();
        return new BufferedReader(new InputStreamReader(socketIn));
    }

    public void run() {
        try {
            BufferedReader br = getReader(socket);
            //PrintWriter pw = getWriter(socket);

            String msg = null;
            while ((msg = br.readLine()) != null) {
                System.out.println(msg);
                //pw.println(echo(msg));
            }


        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
