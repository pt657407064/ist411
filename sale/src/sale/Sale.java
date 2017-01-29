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
public class Sale extends Transaction implements Runnable{

    SaleOrder order;
    public Sale(SaleOrder order) {
        super();
        this.order=order;
    }


    @Override
    public void maketransaction() {    
        System.out.println("Your total is "+ order.getSubtotal());
        order.getOrderList().forEach((k,v)->
                {
                    new Adjustment((InventoryItem)k,(Integer)v).minusStock();
                });
    }

    @Override
    public void run() {
        maketransaction();
    }
    
}
