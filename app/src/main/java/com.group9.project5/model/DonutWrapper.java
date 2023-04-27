package com.group9.project5.model;

public class DonutWrapper {
    private String flavor;
    private String type;
    private int image;

    public DonutWrapper(String flavor, int image, String type){
        this.flavor = flavor;
        this.image = image;
        this.type = type;
    }


    public String getFlavor(){return flavor;}

    public int getImage(){return image;}

    public String getPrice(){return new Donut(flavor,type,1).itemPrice() + "";}
}
