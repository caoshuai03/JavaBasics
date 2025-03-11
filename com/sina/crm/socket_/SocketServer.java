package com.sina.crm.socket_;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.net.ServerSocket;

/**
 * @author caoshuai
 * @version 1.0
 */
public class SocketServer {
    public static void main(String[] args) throws Exception {
        //服务端
        //在本机999端口监听 并且没有被使用9999端口
        ServerSocket serverSocket = new ServerSocket(9989);
        //如果有客户端连接，会返回socket对象，程序继续
        //为了连接多个客户端，一但接受到就有一个新对象
        java.net.Socket accept = serverSocket.accept();
        System.out.println("连接成功");
        //得到socket通道的输入流
        BufferedInputStream bis = new BufferedInputStream(accept.getInputStream());

        //重点是这个已有的算法，输入一个输入流，读取数据存储到字节数组
        byte[] bytes = StreamUtils.streamToByteArray(bis);
        String path="e:/girl.jpg";
        //得到输出流
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(path));
        bos.write(bytes);

        bos.close();
        bis.close();
        accept.close();
        serverSocket.close();
    }
}
