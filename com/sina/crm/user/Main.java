package com.sina.crm.user; /**
 * @author caoshuai
 * @version 1.0
 */

import java.util.Random;
import java.util.Scanner;

public class Main {


    public static void main(String[] args) {
        Tom tom = new Tom();
        tom.playGame();


    }
}

class Encapsul{
    private int age;
    private String name;
    private double banlance;

    public Encapsul() {
    }

    public Encapsul(int age, String name, double banlance) {
        this.setAge(age);
        this.setBanlance(banlance);
        this.setName(name);
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getBanlance() {
        return banlance;
    }

    public void setBanlance(double banlance) {
        this.banlance = banlance;
    }
}


class Tom {
    //
    int sheng;
    int fu;
    double shenglv;



    public void playGame() {
        Scanner sc = new Scanner(System.in);
        int count = 10;
        System.out.println("-----------石头剪刀布游戏开始-----------");
        while (count > 0) {
            System.out.print("请输入你要猜的拳（0表示石头，1表示剪刀，2表示布）" + "你还有" + count + "次机会：");
            int tomNum = sc.nextInt();
            if (tomNum >= 0 && tomNum <= 2) {
                Random r= new Random();
                int autoNum=r.nextInt(3);
//                int autoNum = (int) Math.floor(Math.random() * 3);   //电脑生成的拳
                //判断那边赢了，并且存储输赢
                judge(autoNum, tomNum);
                count--;
            } else {//输入不规范，提示并继续循环
                System.out.println("非法数字！");
            }

        }
        this.shenglv = sheng / 10.0;
        System.out.println("----------游戏结束------------");
        resPrint();

    }

    public void judge(int autoNum, int tomNum) {
        //电脑  玩家
        //0-1f 0-2t 1-2f  1-0t 2-0f 2-1t
        System.out.println("（你）" + int2str(tomNum) + "\tvs\t" + int2str(autoNum) + "（电脑）");
        if (autoNum == tomNum) {//平局
            System.out.println("平局\n");
        } else {
            switch (autoNum - tomNum) {//猜拳作差的数值可以唯一
                case -1:
                case 2: {
                    this.fu++;
                    System.out.println("你输了~\n");
                    break;
                }
                case -2:
                case 1: {
                    this.sheng++;
                    System.out.println("你赢啦！\n");
                    break;
                }
            }

        }

    }

    public void resPrint() {
        System.out.println("胜场：" + this.sheng + "\n负场：" + this.fu );
        System.out.printf("胜率：%.2f%%",shenglv*100);
    }

    public String int2str(int num) {
        if (num == 0) return "石头";
        else if (num == 1) return "剪刀";
        else if (num == 2) return "布";
        return "";


    }

}


class T {
    int N = 10000;
    private boolean[] isCol = new boolean[N];
    private boolean[] dg = new boolean[2 * N];
    private boolean[] udg = new boolean[2 * N];


    //用一个二维数组，行列为对应位置，8行8列，i代表目前放第几个
    //0表示没有放，1表示可以放
    //从这一行第一列开始，如果不行就下一列，如果可以就返回true
    //如果全部遍历都不行，就返回false
    //初始化，全为0
    //....
    //.... 3  5
    //....  7
    public void printArr(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
//            for (int j = 0; j < arr[0].length; j++) {
            System.out.print(arr[i] + " ");
//            }
//            System.out.println();
        }
    }


    public void EightQueens(int[] map, int i) {
        int n = map.length;
        //代表列是否有棋子,0代表没有，1代表有,行不用管，因为每次都会加1
        if (i == n) {
            this.printArr(map);
            System.out.println();
        }//到超过最后一行就回溯
        for (int j = 0; j < n; j++) {//遍历每一列
            if (!isCol[j] && !dg[i - j + n] && !udg[i + j]) {//判断列、对角和负对角
                //说明可以放
                map[i] = j;
                isCol[j] = dg[i - j + n] = udg[i + j] = true;//占用位置
                EightQueens(map, i + 1);
                isCol[j] = dg[i - j + n] = udg[i + j] = false;//释放位置
            }
        }
    }

}

class M {
    private int N = 10000;
    private boolean[] col = new boolean[N];//行
    private boolean[] dg = new boolean[N];//对角线
    private boolean[] udg = new boolean[N];//反对角线


    public void dfs(int[] queen, int i) {
        //queen[i]=j 代表第i行，第j列
        int n = queen.length;
        //结束标志
        if (i == n) {//说明到最后一层了，可以保存结果并返回
            //??存疑，每一次到最后都会有正确结果吗
            this.printArr(queen);//输出结果
            return;
        }
        for (int j = 0; j < n; j++) {//在第i行基础上，遍历列
            if (!col[j] && !dg[i - j + n] && !udg[i + j]) {//判断列、对角和反对角
                //没有冲突的，可以放皇后
                queen[i] = j;//不用恢复现场，直接覆盖，因为用不到里面的结果
                col[j] = dg[i - j + n] = udg[i + j] = true;//占用
                dfs(queen, i + 1);//走下一层
                col[j] = dg[i - j + n] = udg[i + j] = false;//恢复现场，因为后面需要用这个
            }
        }


    }


    public void printArr(int[] queen) {
        for (int i = 0; i < queen.length; i++) {
            System.out.print(queen[i] + " ");
        }
        System.out.println();
    }
}






