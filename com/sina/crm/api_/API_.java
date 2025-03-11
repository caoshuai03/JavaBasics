package com.sina.crm.api_;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * @author caoshuai
 * @version 1.0
 */
public class API_ {
    public static void main(String[] args) throws UnknownHostException {
        //得到本机对象
        InetAddress localHost = InetAddress.getLocalHost();
        System.out.println(localHost);

        //根据主机名得到ip对象
        InetAddress shuai = InetAddress.getByName("shuai");
        System.out.println(shuai);
        //根据域名得到其ip对象
        InetAddress byName = InetAddress.getByName("www.baidu.com");
        System.out.println(byName);

        //通过对象得到ip地址
        String hostAddress = byName.getHostAddress();
        System.out.println(hostAddress);
        //通过对象得到域名
        String hostName = byName.getHostName();
        System.out.println(hostName);


    }
}
