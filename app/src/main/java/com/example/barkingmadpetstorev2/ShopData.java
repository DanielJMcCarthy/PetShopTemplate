package com.example.barkingmadpetstorev2;

public class ShopData {

    private int itemImage;
    private String itemTitle;
    private String itemPrice;


    public ShopData(int itemImage, String itemTitle, String itemPrice) {
        this.itemImage = itemImage;
        this.itemTitle = itemTitle;
        this.itemPrice = itemPrice;
    }


    public int getItemImage() {
        return itemImage;
    }

    public void setItemImage(int itemImage) {
        this.itemImage = itemImage;
    }

    public String getItemTitle() {
        return itemTitle;
    }

    public void setItemTitle(String itemTitle) {
        this.itemTitle = itemTitle;
    }

    public String getItemPrice() {
        return itemPrice;
    }

    public void setItemPrice(String itemPrice) {
        this.itemPrice = itemPrice;
    }
}
