/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sale;

import item.InventoryItem;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author root
 */
public class ReturnOrder extends Order{

    private double subtotal;
    private Map<InventoryItem,Integer> InventoryItems = new HashMap<>();

    public ReturnOrder(int oNumber) {
        super(oNumber);
    }

    
    @Override
    public void calculationTotal() {
       InventoryItems.forEach((k,v)->
        {
            this.subtotal += (k.getPrice()*v);
        });
        
    }
    
    @Override
    public double getSubtotal() {
        return subtotal;
    }

    @Override
    public Map getOrderList() {
        return this.InventoryItems;
    }

    @Override
    public void addOrder(InventoryItem item, int quan) {
        this.InventoryItems.put(item, quan);
        calculationTotal();
    }    

    @Override
    public int getOrderNumber() {
        return super.oNumber;
    }
}
