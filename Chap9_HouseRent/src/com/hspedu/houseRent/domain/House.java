package com.hspedu.houseRent.domain;

public class House {
    private int id;
    private String name;
    private String phoneNum;
    private String address;
    private double rent;
    private String state;

    public String getName() {
        return name;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public String getAddress() {
        return address;
    }

    public double getRent() {
        return rent;
    }

    public String getState() {
        return state;
    }

    public House(int id, String name, String phoneNum, String address, double rent, String state) {
        this.id = id;
        this.name = name;
        this.phoneNum = phoneNum;
        this.address = address;
        this.rent = rent;
        this.state = state;
    }

    @Override
    public String toString() {
        return  '\t' + id
                + '\t' + name
                + '\t' + phoneNum
                + '\t' + address
                + '\t' + rent
                + '\t' + state;
    }
}
