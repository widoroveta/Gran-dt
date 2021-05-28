package com.company.enums;

public enum Prices {
    P1(500), P2(1000), P3(1500), P4(2000), P5(2500), P6(3000), P7(3500), P8(4000), P9(4500), P10(5000);
    int price;

    Prices(int price) {
        this.price = price;
    }

    public int getPrice() {
        return price;
    }

}
