package com.group9.project5.model;
import android.util.Log;

import androidx.annotation.NonNull;

import java.util.*;

/**
 * Order class that holds finalized orders.
 * @author William Barrese, Andy Nguyen
 */
public class Order {
    /**
     * Variable for Order number
     */
    private int orderNumber;
    /**
     * ArrayList menu items.
     */
    private ArrayList<MenuItem> menuItems = new ArrayList<MenuItem>();

    private static Order CURRENT_ORDER = new Order();
    private static int CURRENT_ORDER_NUM = 0;

    public static ArrayList<Order> FINALIZED_ORDERS = new ArrayList<>();

    /**
     * Order constructor assigns an order number to an order.
     */
    private Order(){
        CURRENT_ORDER_NUM += 1;
        this.orderNumber = CURRENT_ORDER_NUM;
    }

    public static Order getCurrentOrder(){
        return CURRENT_ORDER;
    }

    private void createNewOrder(){
        CURRENT_ORDER = new Order();
    }

    public void FinalizeOrder(){
        FINALIZED_ORDERS.add(CURRENT_ORDER);
        Log.d("Order#" , CURRENT_ORDER_NUM + "");
        createNewOrder();
    }

    /**
     * Order constructor with order number and ordered items.
     * @param orderNumber Order id number
     * @param menuItems List of items
     */
    public Order(int orderNumber, ArrayList menuItems){
        this.orderNumber = orderNumber;
        this.menuItems = menuItems;
    }

    /**
     * Adds one item to the order
     * @param item Item to be added
     */
    public void add(MenuItem item){
        this.menuItems.add(item);
    }

    /**
     * Removes entire quantity of selectedItem
     * @param selectedItem Name of item to be removed
     */
    public void remove(MenuItem selectedItem) {
        this.menuItems.remove(selectedItem);
    }

    /**
     * Getter method for order number.
     * @return order number
     */
    public int getOrderNumber() {
        return orderNumber;
    }

    /**
     * Getter method to get total price of an order.
     * @return Total price of order
     */
    public double getTotal(){
        double sub = 0.0;
        for (MenuItem item:
                this.menuItems) {
            sub += item.itemPrice();
        }
        return Math.round((sub * (1.0 + MenuItem.TAX)) * 100.0)/100.0;
    }

    /**
     * Getter method to get items ordered into an ArrayList.
     * @return menu items
     */
    public ArrayList<MenuItem> getMenuItems() {
        return menuItems;
    }

    @NonNull
    @Override
    public String toString() {
        return "Order# " + this.getOrderNumber() + " \t $" + this.getTotal();
    }
}