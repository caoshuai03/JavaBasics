package com.sina.crm.house.service;

import com.sina.crm.house.model.House;
import com.sina.crm.house.utils.Utility;

/**
 * @author caoshuai
 * @version 1.0
 * house数组放在这里
 * <p>
 * 响应houseview的调用
 * <p>
 * 完成各种操作 crud 增删改查 create read update delete
 */
public class HouseService {

    private House[] houses;//先声明
    private int houseSize = 0;//记录房屋个数
    private int idCounter = 0;//记录id

    public HouseService(int size) {
        this.houses = new House[size];
        //再开辟空间，因为不知道开辟多少
    }

    public House[] list() {
        //返回数组 可以显示列表
        return this.houses;
    }

    public boolean add(House house) {
        //传入需要添加的元素，在这里对数组进行添加操作
        if (houseSize == houses.length) {
            System.out.println("数组已满");
            return false;
        }
        house.setId(++idCounter);
        houses[houseSize++] = house;
        return true;

    }

    public boolean delete(int id) {
        if (!(id > 0 && id <= houseSize)) {
            System.out.println("输入id有误");
            return false;
        }
        //判断是否真的要删除
        while (true) {//开始循环
            System.out.print("确认是否删除（Y/N）：请小心选择：");
            char key = Utility.readChar('N');
            if (key == 'N' || key == 'n') {//如果不删除
                System.out.println("取消删除！");
                return false;
            } else if (key == 'y' || key == 'Y') {
                //开始删除

                for (int i = id - 1; i < houseSize - 1; i++) {
                    //从要删的位置，后一个替代前一个
                    houses[i] = houses[i + 1];
                    houses[i].setId(i + 1);

                }
                houses[--houseSize] = null;
                idCounter--;
                return true;
            }
        }//如果输入其他数据 就继续循环


    }

    public House find(int id) {
        if (!(id > 0 && id <= houseSize)) {
            System.out.println("id有误，没有找到房屋信息");
            return null;
        }
        return houses[id - 1];

    }

    public House[] getHouses() {
        return houses;
    }

    public void setHouses(House[] houses) {
        this.houses = houses;
    }

    public int getHouseSize() {
        return houseSize;
    }

    public void setHouseSize(int houseSize) {
        this.houseSize = houseSize;
    }

    public int getIdCounter() {
        return idCounter;
    }

    public void setIdCounter(int idCounter) {
        this.idCounter = idCounter;
    }
}
