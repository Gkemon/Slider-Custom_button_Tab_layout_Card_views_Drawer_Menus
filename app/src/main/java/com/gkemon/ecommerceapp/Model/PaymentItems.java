package com.gkemon.ecommerceapp.Model;

/**
 * Created by Gk emon on 2/18/2018.
 */

public class PaymentItems {
    public int image;
    public String method;
    public PaymentItems() {

    }

    public PaymentItems(int image, String method) {
        this.image = image;
        this.method = method;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }
}
