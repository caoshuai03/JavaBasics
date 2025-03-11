package com.sina.crm.house;

import com.sina.crm.house.view.HouseView;

/**
 * @author caoshuai
 * @version 1.0
 */
public class HouseRentApp {
    public static void main(String[] args) {
        //程序入口
        new HouseView().mainMenu();
        System.out.println("======退出房屋出租系统======");
    }
}
