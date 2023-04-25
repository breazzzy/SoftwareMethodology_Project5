package com.group9.project5.model;

/**
 * Donut class for RecyclerView
 * @author William Barrese, Andy Nguyen
 */
public class Donut{
    private String flavor;
    private int image;
    private double unitPrice = 1.79;

    public Donut(String flavor, int image, double unitPrice){
        this.flavor = flavor;
        this.image = image;
        this.unitPrice = unitPrice;
    }

    public String getFlavor(){return flavor;}

    public int getImage(){return image;}

    public double getUnitPrice(){return unitPrice;}
}
