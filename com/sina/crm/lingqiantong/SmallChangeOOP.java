package com.sina.crm.lingqiantong;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class SmallChangeOOP {
    Scanner scanner = new Scanner(System.in);
    String detail = "--------------零钱通明细-------------";
    double bonus = 0;//余额
    Date date = null;//声明
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");

    int key;
    boolean tag = true;

    public void menu() {

        do {
            System.out.println("\n===============零钱通账户================"
                    + "\n\t\t\t 1 零钱通明细"
                    + "\n\t\t\t 2 收益入账"
                    + "\n\t\t\t 3 消费"
                    + "\n\t\t\t 4 退     出"
            );
            System.out.print("请选择（1-4）：");
            try {
                key = scanner.nextInt();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }

            switch (key) {
                case 1: {
                    this.showDetail();
                    break;
                }
                case 2: {
                    this.shouRu();
                    break;
                }
                case 3: {
                    this.xiaoFei();
                    break;
                }
                case 4: {
                    this.exit();
                    break;
                }
                default:
                    System.out.println("输入有误，请重新输入");
            }

        } while (tag);
        System.out.println("======成功退出零钱通，欢迎下次使用======");

    }

    public void showDetail() {
        System.out.println(detail);
    }

    public void shouRu() {
        System.out.println("请输入你要入账的金额：");
        double ruZhang = scanner.nextDouble();
        if (ruZhang <= 0) {
            System.out.println("你的金额应该大于 0");
            return;
        }
        //对金额进行校验！
        bonus += ruZhang;
        //读取现在时间
        date = new Date();
        detail += "\n收益入账\t" + "+" + ruZhang + "\t" + simpleDateFormat.format(date) + "\t" + bonus;
        System.out.println("成功存入" + ruZhang + "元");

    }

    public void xiaoFei() {
        System.out.println("请输入消费金额");
        double money = scanner.nextDouble();
        //进行校验
        if (money <= 0) {
            System.out.println("输入错误");
            return;
        } else if (money > bonus) {
            System.out.println("余额不够");
            return;
        }
        bonus -= money;
        System.out.println("请输入消费原因");
        String reason = scanner.next();//NEXT就是传入字符串
        date = new Date();
        detail += "\n" + reason + "\t" + "-" + money + "\t" + simpleDateFormat.format(date) + "\t" + bonus;
        System.out.println("金额" + money + "已扣除");
    }

    public void exit() {
        do {
            System.out.println("您确认要退出吗?y/n");
            String isExit = scanner.next();
            if (isExit.charAt(0) == 'y') {
                tag = false;
                break;
            } else if (isExit.charAt(0) == 'n') {
                break;
            } else System.out.println("请重新输入");
        } while (true);
    }
}
