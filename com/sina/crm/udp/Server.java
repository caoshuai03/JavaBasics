package com.sina.crm.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

/**
 * @author caoshuai
 * @version 1.0
 */
public class Server {
    public static void main(String[] args) throws IOException {

        DatagramSocket datagramSocket = new DatagramSocket(9989);

        //UDP协议最大64K 64*1024*8
        byte[] bytes = new byte[64 * 1024];//数组长度是属性，高级的集合长度是方法
        DatagramPacket datagramPacket = new DatagramPacket(bytes, bytes.length);
        //通过网络通道，把数据放到packet包
        //即等待中，没有数据会阻塞
        System.out.println("等待接受");
        datagramSocket.receive(datagramPacket);


        int len = datagramPacket.getLength();
        //接受数据，是字节数组形式
        byte[] data = datagramPacket.getData();
        System.out.println(new String(data, 0, len));

        //关闭资源
        datagramSocket.close();


    }
}


