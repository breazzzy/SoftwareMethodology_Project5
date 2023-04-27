package com.group9.project5.model;

public class DonutWrapper {
    private String text;
    private String flavor;
    private String type;
    private int image;

    public DonutWrapper(String text, String flavor, int image, String type){
        this.text = text;
        this.flavor = flavor;
        this.image = image;
        this.type = type;
    }

    public String getText(){return text;}

    public String getFlavor(){return flavor;}

    public String getType(){return type;}

    public int getImage(){return image;}

    public String getPrice(){return new Donut(flavor,type,1).itemPrice() + "";}
}
