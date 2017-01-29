/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sale;

import item.InventoryItem;

/**
 *
 * @author root
 */
public class Adjustment {
    
    private InventoryItem item;
    private int quantity;
    public Adjustment(InventoryItem item, int quantity)
    {
        this.item = item;
        this.quantity = quantity;
    }
    
    public void addStock()
    {
        this.item.setQuant(this.item.getQuant()+this.quantity);
    }
    public void minusStock()
    {
        this.item.setQuant(this.item.getQuant()-this.quantity);
       
    }
}
