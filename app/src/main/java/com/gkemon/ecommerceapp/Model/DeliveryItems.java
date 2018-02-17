package com.gkemon.ecommerceapp.Model;

/**
 * Created by Gk emon on 2/16/2018.
 */

public class DeliveryItems {
    public int imageResource;
    public String price;
    public String method;

    public DeliveryItems(int imageResource, String price, String method) {
        this.imageResource = imageResource;
        this.price = price;
        this.method = method;
    }

    public int getImageResource() {
        return imageResource;
    }

    public void setImageResource(int imageResource) {
        this.imageResource = imageResource;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }
}
