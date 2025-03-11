package com.sina.crm.udp;

import java.io.IOException;
import java.net.*;

/**
 * @author caoshuai
 * @version 1.0
 */
public class Client {
    public static void main(String[] args) throws IOException {

        //也要设置端口
        DatagramSocket socket = new DatagramSocket(9988);

        byte[] bytes = "hello,world!".getBytes();

        //装包，指定ip和端口
        DatagramPacket packet =
                new DatagramPacket(bytes, bytes.length, InetAddress.getLocalHost(), 9989);

        //直接发送
        System.out.println("发送数据");
        socket.send(packet);

        //释放
        socket.close();

    }
}


