package com.sina.crm.paint_;

import javax.swing.*;
import java.awt.*;

/**
 * @author caoshuai
 * @version 1.0
 */
public class DrawCircle extends JFrame {

    private MyPanel myPanel = null;

    public static void main(String[] args) {

        new DrawCircle();


    }

    public DrawCircle() {
        myPanel = new MyPanel();
        this.add(myPanel);
        this.setSize(400, 500);
        this.setVisible(true);
    }
}

class MyPanel extends JPanel {


    @Override
    public void paint(Graphics g) {
        super.paint(g);
//        g.drawOval(10, 10, 200, 300);
        Image image = Toolkit.getDefaultToolkit().getImage(MyPanel.class.getResource("/0040jbadly1h6uficbnocj62c0340qv602.jpg"));
        g.drawImage(image, 10, 10, 400, 500, this);
    }
}

//单利模式 饿汉式  （一次性创建对象）
//        懒汉式  （先声明后创建）
class GirlFriend {
    private String name;

    private static GirlFriend girlFriend = new GirlFriend("marry");

    //私有是禁止访问，static是用类直接调用方法可以得到对象
    private GirlFriend(String name) {
        this.name = name;
    }

    public static GirlFriend getInstance() {
        return girlFriend;
    }

}

class BoyFriend {
    private String name;
    private static BoyFriend boyFriend;//先声明

    private static BoyFriend getInstance() {
        if (boyFriend == null) {//第一次为空就开辟空间
            boyFriend = new BoyFriend("小帅");
            return boyFriend;
        }
        return boyFriend;
    }

    private BoyFriend(String name) {
        this.name = name;
    }
}