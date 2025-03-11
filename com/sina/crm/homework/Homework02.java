package com.sina.crm.homework;

import java.util.Scanner;

/**
 * @author caoshuai
 * @version 1.0
 */
public class Homework02 {
    @SuppressWarnings({"all"})
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("请输入用户名");
            String name = sc.next();
            //判断用户名
            if (!(A.isName(name)))//返回false代表信息不正确
                System.out.println("用户名长度为2、3、4！");
            else break;
        }

        while (true) {
            System.out.println("请输入密码");
            String password = sc.next();
            if (!(A.isPassword(password)))
                System.out.println("密码长度为6，并且全部是数字");
            else break;
        }
        //判断密码
        System.out.println("请输入邮箱");
        String mail = sc.next();
        if (!(A.isMail(mail))) System.out.println("邮箱错误");

    }


}

class A {
    public static boolean isName(String name) {
        int n = name.length();
        if (!(n >= 2 && n <= 4)) return false;
        return true;
    }


    public static boolean isPassword(String pw) {
        if (!(pw.length() >= 6 && A.isDigital(pw))) return false;
        return true;
    }

    public static boolean isDigital(String pw) {
        int n = pw.length();
        for (int i = 0; i < n; i++) {
            if (!(pw.charAt(i) >= '0' && pw.charAt(i) <= '9')) return false;
        }
        return true;
    }

    public static boolean isMail(String mail) {
        if (!(mail.contains("@") && mail.contains("."))) return false;
        if (!((mail.indexOf("@") - mail.indexOf(".") < 0))) return false;
        return true;
    }


}

