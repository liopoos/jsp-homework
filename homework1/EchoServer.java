/**
 * Created by hades on 2017/3/16.
 */

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoServer {
    private int port = 8000;   //定义服务器连接端口
    private ServerSocket serverSocket;

    public EchoServer() throws IOException {
        serverSocket = new ServerSocket(port);  //新建serverSocket对象，绑定连接端口port
        System.out.println("服务器启动...");
    }

    public void service() throws IOException {
        Socket socket = null;
        try {
            int count = 0;
            while (true) {
                socket = serverSocket.accept();
                //创建一个新的线程
                ServerThread serverThread = new ServerThread(socket, count);
                //启动线程
                serverThread.start();
                System.out.println("客户端" + count + "已连接");
                System.out.println("套接字信息：" + socket);
                System.out.println("当前客户端的IP：" + socket.getInetAddress() + ":" + socket.getPort());
                count++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (socket != null)
                    socket.close();  //断开连接
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String args[]) throws IOException {
        new EchoServer().service();
    }
}
