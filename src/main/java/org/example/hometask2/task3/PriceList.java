package org.example.hometask2.task3;

import java.util.HashMap;

public class PriceList {
    private HashMap<String, Double> priceList;

    public PriceList(HashMap<String, Double> priceList) {
        this.priceList = priceList;
    }

    public PriceList() {
        priceList = new HashMap<>();
    }

    public void addPriceProduct(String product, Double price) {
        this.priceList.put(product, price);
    }

    public void changeProductPrice(String product, Double price) {
        this.priceList.put(product, price);
    }

    public void getProductPrice(String product) {
        System.out.println(this.priceList.get(product));
    }

}
