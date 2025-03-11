package com.sina.crm.socket_;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.net.InetAddress;
import java.net.Socket;

/**
 * @author caoshuai
 * @version 1.0
 */
public class SocketClient {
    public static void main(String[] args) throws Exception {
        //客户端
        //输入是 一个ip对象和端口，连接此对象
        Socket socket = new Socket(InetAddress.getLocalHost(), 9989);
        System.out.println("连接成功");

        //读取图片
        String path="E:\\test.jpg";
        BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(path));
        //重点是这个已有的算法，输入一个输入流，读取数据存储到字节数组
        byte[] bytes = StreamUtils.streamToByteArray(bufferedInputStream);

        //得到输出流对象
        BufferedOutputStream bos = new BufferedOutputStream(socket.getOutputStream());
        //直接传输这个字节数组到输出通道
        bos.write(bytes);

        bufferedInputStream.close();
        socket.shutdownOutput();
        bos.close();
        socket.close();







        //最后要关闭流
        socket.close();
    }
}
