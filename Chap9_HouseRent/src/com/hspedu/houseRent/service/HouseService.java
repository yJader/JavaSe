package com.hspedu.houseRent.service;

import com.hspedu.houseRent.domain.House;

public class HouseService {
    private House[] houses;

    public HouseService(int size) {
        houses = new House[size];
    }

    public House[] getHouses() {
        //获取房屋信息
        return houses;
    }
}
