package com.hspedu.houseRent;

import com.hspedu.houseRent.view.HouseView;

public class HouseRentApp {
    public static void main(String[] args) {
        //程序的主入口,创建并调用HouseView对象
        new HouseView().mainMenu();
        System.out.println("========您已退出房屋租赁系统=======");
    }
}
