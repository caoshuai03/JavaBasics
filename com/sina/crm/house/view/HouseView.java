package com.sina.crm.house.view;

/**
 * @author caoshuai
 * @version 1.0
 */

import com.sina.crm.house.model.House;
import com.sina.crm.house.service.HouseService;
import com.sina.crm.house.utils.Utility;

/**
 * 显示界面
 * <p>
 * 接受用户的输入
 * <p>
 * 调用其他房屋操作
 */
public class HouseView {
    private boolean loop = true;
    private char key = ' ';

    //为什么现在要创建hservice对象
    private HouseService houseService = new HouseService(10);

    public void listHouse() {
        //显示列表 houseservice没有数组
        House[] list = houseService.list();
        if (houseService.getHouseSize() == 0) {
            System.out.println("暂无房屋信息，请添加房屋");
            return;
        }
        System.out.println("==============房屋列表=============");
        System.out.println("编号\t\t房主\t\t电话\t\t地址\t\t月租\t\t状态");

        for (int i = 0; i < list.length; i++) {//大小有问题
            if (list[i] != null)
                System.out.println(list[i]);

        }
    }


    public void addHouse() {
        //添加元素 在这里只需要得到添加的元素
        //得到一个house
        System.out.println("请输入名字");
        String name = Utility.readString(10);
        System.out.println("请输入电话号码");
        String phone = Utility.readString(10);
        System.out.println("请输入地址");
        String address = Utility.readString(10);
        System.out.println("请输入租金");
        int rent = Utility.readInt();
        System.out.println("请输入状态");
        String state = Utility.readString(10);
        House house = new House(0, name, phone, address, rent, state);
        if (houseService.add(house)) {
            System.out.println("添加成功");
        }

    }

    public void deleteHouse() {
        //得到id

        int id = 0;
        while (id != -1) {
            System.out.print("\n请输入要删除的房屋id(-1退出):");
            id = Utility.readInt();
            if (houseService.delete(id)) {
                System.out.println("id" + id + "删除成功");
                listHouse();
                break;
            } else System.out.println("删除失败");
        }


    }

    public void findHouse() {
        System.out.print("请输入你要查找的id：");
        int id = Utility.readInt();
        House house = houseService.find(id);
        if (house == null) {
            System.out.println("查找失败");
        } else {
            System.out.println(house);
        }

    }

    public void mainMenu() {
        do {
            System.out.println("=========房屋出租系统==========");
            System.out.println("\t\t\t1 新增房源");
            System.out.println("\t\t\t2 查找房源");
            System.out.println("\t\t\t3 删除房屋信息");
            System.out.println("\t\t\t4 修改房屋信息");
            System.out.println("\t\t\t5 房屋列表");
            System.out.println("\t\t\t6 退出");
            System.out.println("请输入你的选择（1-6）:");
            key = Utility.readChar();
            switch (key) {
                case '1':
                    addHouse();
                    break;
                case '2':
                    findHouse();
                    break;
                case '3':
                    deleteHouse();
                    break;
                case '4':
                    System.out.println();
                    break;
                case '5':
                    listHouse();
                    break;
                case '6':
                    while (true) {
                        System.out.println("您确认要退出吗（Y/N）:");
                        char key = Utility.readChar('N');
                        if (key == 'N' || key == 'n') {
                            break;
                        } else if (key == 'y' || key == 'Y') {
                            loop = false;
                            break;
                        }
                    }


            }

        } while (loop);
    }
}
