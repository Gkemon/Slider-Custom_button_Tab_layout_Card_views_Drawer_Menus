package com.gkemon.ecommerceapp.Model;

/**
 * Created by Gk emon on 2/18/2018.
 */

public class ConfirmItem {
    int quantity;
    String productName;
    String Size;
    double prices;
    int imageResource;

    public ConfirmItem(int quantity, String productName, String size, double prices, int imageResource) {
        this.quantity = quantity;
        this.productName = productName;
        Size = size;
        this.prices = prices;
        this.imageResource = imageResource;
    }

    public int getQuantity() {
        return quantity;
    }

    public String getProductName() {
        return productName;
    }

    public String getSize() {
        return Size;
    }

    public double getPrices() {
        return prices;
    }

    public int getImageResource() {
        return imageResource;
    }
}
