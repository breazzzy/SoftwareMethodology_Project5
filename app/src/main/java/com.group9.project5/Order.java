package com.group9.project5;
import java.util.*;

/**
 * Order class that holds finalized orders.
 * @author William Barrese, Andy Nguyen
 */
public class Order {
    /**
     * Variable for Order number
     */
    private int orderNumber = 1;
    /**
     * ArrayList menu items.
     */
    private ArrayList<MenuItem> menuItems = new ArrayList<MenuItem>();

    private static Order CURRENT_ORDER = new Order();

    public static ArrayList<Order> FINALIZED_ORDERS = new ArrayList<>();

    /**
     * Order constructor assigns an order number to an order.
     */
    private Order(){
        this.orderNumber = orderNumber;
        orderNumber += 1;
    }

    public static Order getCurrentOrder(){
        return CURRENT_ORDER;
    }

    private void createNewOrder(){
        CURRENT_ORDER = new Order();
    }

    public void FinalizeOrder(){
        FINALIZED_ORDERS.add(CURRENT_ORDER);
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
        return sub * (1.0 + MenuItem.TAX);
    }

    /**
     * Getter method to get items ordered into an ArrayList.
     * @return menu items
     */
    public ArrayList<MenuItem> getMenuItems() {
        return menuItems;
    }
}