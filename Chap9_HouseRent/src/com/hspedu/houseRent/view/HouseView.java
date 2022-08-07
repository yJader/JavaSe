package com.hspedu.houseRent.view;

import com.hspedu.houseRent.domain.House;
import com.hspedu.houseRent.service.HouseService;
import com.hspedu.houseRent.utils.Utility;

public class HouseView {

    private boolean loop = true;
    private char key = ' ';
    private HouseService houseService = new HouseService(100);

    public void mainMenu() {
        System.out.println("================房屋租赁系统==============");
        System.out.println("\t\t\t1. 新 增 房 屋 信 息");
        System.out.println("\t\t\t2. 查 找 房 屋 信 息");
        System.out.println("\t\t\t3. 删 除 房 屋 信 息");
        System.out.println("\t\t\t4. 修 改 房 屋 信 息");
        System.out.println("\t\t\t5. 查 看 房 屋 列 表");
        System.out.println("\t\t\t6. 退 出 系 统");
        System.out.println("请输入您的选择(1-6): ");
        key = Utility.readChar();
        switch (key) {
            case '1':
                System.out.println("新 增");
                break;
            case '2':
                System.out.println("查 找");
                break;
            case '3':
                System.out.println("删 除");
                break;
            case '4':
                System.out.println("修改");
                break;
            case '5':
                System.out.println("查 看");
                break;
            case '6':
                System.out.println("退 出");
                break;
        }

    }

    public void showHouses(){
        System.out.println("=============房屋列表=============");
        System.out.println("编号\t\t房主\t\t电话\t\t地址\t\t月租\t\t状态(已出售/未出售)");
        House[] houses = houseService.getHouses();
        for (int i = 0; i < houses.length; i++) {
            
        }
    }
}