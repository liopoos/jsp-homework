/**
 * Created by hades on 2017/3/17.
 */

import java.io.*;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

class allClient { //保存socket
    List list = new ArrayList();

    public void addList(Socket socket) {
        list.add(socket);
    }

    public void showList() {
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }

    public Socket getList(int n) {
        return (Socket) list.get(n);
    }

    public int getSize() {
        return list.size();
    }

}

public class ServerThread extends Thread {
    Socket socket = null;
    int count = 0;
    Socket socket1 = null;
    private static allClient list = new allClient();

    public ServerThread(Socket socket, int count) {

        this.socket = socket;
        this.count = count;
        list.addList(socket);
        list.showList();
    }

    public String echo(String msg, int count) {

        return "客户端" + count + "说:" + msg;
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

            String msg = null;
            while ((msg = br.readLine()) != null) {
                for (int i = 0; i < list.getSize(); i++) {
                    //System.out.println(getName());
                    socket1 = list.getList(i);
                    PrintWriter pw = getWriter(socket1);
                    pw.println(echo(msg, count));
                }

            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (socket != null) socket.close();  //断开连接
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
