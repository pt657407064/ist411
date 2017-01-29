/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sale;

import item.InventoryItem;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 *
 * @author root
 */
public abstract class Order {
    
    protected int oNumber;
    protected Order(int oNumber)
    {
        this.oNumber = oNumber;
    }
    
    public abstract void calculationTotal();
    public abstract double getSubtotal();
    public abstract Map getOrderList();
    public abstract void addOrder(InventoryItem item, int quan);
    public abstract int getOrderNumber();
}
