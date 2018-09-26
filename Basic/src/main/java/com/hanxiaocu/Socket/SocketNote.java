package com.hanxiaocu.Socket;

//import javax.mail.Message;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketTimeoutException;

/**
 * Description:
 * User: hanchenghai
 * Date: 2018/09/06 上午10:39
 */
public class SocketNote {
    //客户端
    static class GreetingClient {
        public static void main(String[] args) {
            String serverName = args[0];
            int port = Integer.parseInt(args[1]);
            try {
                System.out.println("连接到主机： " + serverName + " ,端口号： " + port);
                Socket server = new Socket(serverName, port);
                System.out.println("远程主机地址： " + server.getRemoteSocketAddress());

                OutputStream outToserver = server.getOutputStream();
                DataOutputStream out = new DataOutputStream(outToserver);

                out.writeUTF("Hello from" + server.getLocalSocketAddress());

                InputStream inFromServer = server.getInputStream();
                DataInputStream in = new DataInputStream(inFromServer);
                System.out.println("服务器响应： " + in.readUTF());
                server.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


    static class GreetingServer extends Thread {
        private ServerSocket serverSocket;

        @Override
        public void run() {
            while (true) {
                try {
                    System.out.println("等待远程连接,端口号为：" + serverSocket.getLocalPort() + "...");
                    //accept() 方法返回服务器上一个新的 socket 引用，该 socket 连接到客户端的 socket。
                    Socket client = serverSocket.accept();
                    System.out.println("远程主机地址：" + client.getRemoteSocketAddress());
                    DataInputStream in = new DataInputStream(client.getInputStream());
                    System.out.println(in.readUTF());
                    DataOutputStream out = new DataOutputStream(client.getOutputStream());
                    out.writeUTF("谢谢链接我 " + client.getLocalSocketAddress() + "\n 拜拜");
                    client.close();
                } catch (SocketTimeoutException s) {
                    System.out.println("Socket timed out!");
                    break;
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }

        public GreetingServer(int port) throws IOException {
            serverSocket = new ServerSocket(port);
            serverSocket.setSoTimeout(10000);
        }


        public static void main(String[] args) {
            int port = Integer.parseInt(args[0]);
            try {
                Thread t = new GreetingServer(port);
                t.run();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


}


}