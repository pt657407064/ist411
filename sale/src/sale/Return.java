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
public class Return extends Transaction implements Runnable {

    ReturnOrder order;
    public Return(ReturnOrder order) {
        super();
        this.order =order;
    }

    @Override
    public void maketransaction() {
        System.out.println("You return change "+order.getSubtotal());
        order.getOrderList().forEach((k,v)->{
            new Adjustment((InventoryItem)k,(Integer)v).addStock();
        });
    }

    @Override
    public void run() {
        maketransaction();
    }
    
}
