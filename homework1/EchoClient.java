/**
 * Created by hades on 2017/3/16.
 */

import java.io.*;
import java.net.Socket;

public class EchoClient {
    private String host = "localhost";
    private int port = 8000;
    private Socket socket;

    public EchoClient() throws IOException {
        socket = new Socket(host, port);   //建立socket对象，用于与服务器的通信，需要绑定服务器端口。
        //ClientThread clientThread=new ClientThread(socket);
        //clientThread.start();
        System.out.println("客户端套接字信息：" + socket);
    }

    private PrintWriter getWriter(Socket socket) throws IOException {  //输出流
        OutputStream socketOut = socket.getOutputStream();
        return new PrintWriter(socketOut, true);
    }

    private BufferedReader getReader(Socket socket) throws IOException {  //输入流
        InputStream socketIn = socket.getInputStream();
        return new BufferedReader(new InputStreamReader(socketIn));
    }

    public void talk() throws IOException {
        try {
            ClientThread clientThread = new ClientThread(socket);
            //启动线程
            clientThread.start();
            BufferedReader br = getReader(socket);
            PrintWriter pw = getWriter(socket);
            BufferedReader localReader = new BufferedReader(new InputStreamReader(System.in));
            String msg = null;
            while ((msg = localReader.readLine()) != null) {
                pw.println(msg);
                System.out.println(br.readLine());

            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String args[]) throws IOException {
        new EchoClient().talk();
    }
}

