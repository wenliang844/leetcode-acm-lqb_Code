package Codejava.MyCode.socket;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class MultiWebServer {
    public static void main(String[] args) {
        try {
            String base_url = "F://";
            ServerSocket serverSocket = new ServerSocket(80);
            System.out.println("正在等待情书中...");
            Socket socket = serverSocket.accept();
            System.out.println("收到情书，我要开始解析！");
            InputStream inputStream = socket.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            String line = reader.readLine();
            System.out.println(line);
            String url = line.substring(5, line.indexOf("HTTP") - 1);
            System.out.println("情书解析完毕，我要想想怎么回复了...");
            //获取文件内容
            inputStream = new FileInputStream(base_url + url);
            OutputStream outputStream = socket.getOutputStream();
            byte[] buffer = new byte[4 * 1024];
            int len = 0;
            while ((len = inputStream.read(buffer)) != -1) {
                outputStream.write(buffer, 0, len);
            }
            outputStream.flush();
            System.out.println("情书请求已发送给客户端");
            //关闭对应的资源
            serverSocket.close();
            socket.shutdownInput();
            socket.close();
            inputStream.close();
            reader.close();
            outputStream.close();
        } catch (Exception e) {
        }
    }
}