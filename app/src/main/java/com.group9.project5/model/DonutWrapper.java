package com.group9.project5.model;

public class DonutWrapper {
    private String flavor;
    private int image;
    private String price;

    public DonutWrapper(String flavor, int image, String price){
        this.flavor = flavor;
        this.image = image;
        this.price = price;
    }

    public String getFlavor(){return flavor;}

    public int getImage(){return image;}

    public String getPrice(){return price;}
}
