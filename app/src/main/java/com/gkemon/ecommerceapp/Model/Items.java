package com.gkemon.ecommerceapp.Model;

/**
 * Created by Gk emon on 2/11/2018.
 */

public class Items {
    private String offer;
    private String productName;
    private String Promotion;
    private int Image;


public Items(){
}
    public void setImage(int image) {
        Image = image;
    }

    public int getImage() {
        return Image;
    }

    public String getOffer() {
        return offer;
    }

    public String getProductName() {
        return productName;
    }

    public String getPromotion() {
        return Promotion;
    }

    public void setOffer(String offer) {
        this.offer = offer;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public void setPromotion(String promotion) {
        Promotion = promotion;
    }
}
