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
public class Exchange extends Transaction implements Runnable{

    Order tradIn;
    Order tradOff;
    public Exchange(Order tradIn, Order tradOff) {
        super();
        this.tradIn = tradIn;
        this.tradOff =tradOff;
    }

    @Override
    public void maketransaction() {
        if(tradOff.getSubtotal() > tradIn.getSubtotal())
        {
           
            tradOff.getOrderList().forEach((k,v)->
            {
                tradIn.getOrderList().forEach((key,vec)->{
                    if(k == key&& (Integer)v>(Integer)vec)
                    {
                        new Adjustment((InventoryItem)k,(Integer)v-(Integer)vec).minusStock();
                    }
                    else if(k == key&& (Integer)v<(Integer)vec)
                    {
                        new Adjustment((InventoryItem)k,(Integer)vec-(Integer)v).addStock();
                    }
                    else if(k!=key){
                        new Adjustment((InventoryItem)k,(Integer)v).minusStock();
                        new Adjustment((InventoryItem)key,(Integer)vec).addStock();
                    }
                });
            });
             System.out.println("You need to pay: " + (tradOff.getSubtotal()-tradIn.getSubtotal()));
        }
        else if(tradOff.getSubtotal() < tradIn.getSubtotal())
        {
            
            tradOff.getOrderList().forEach((k,v)->
            {
                tradIn.getOrderList().forEach((key,vec)->{
                    if(k == key&& (Integer)v>(Integer)vec)
                    {
                        new Adjustment((InventoryItem)k,(Integer)v-(Integer)vec).minusStock();
                    }
                    else if(k == key&& (Integer)v<(Integer)vec)
                    {
                        new Adjustment((InventoryItem)k,(Integer)vec-(Integer)v).addStock();
                    }
                    else if(k != key)
                    {
                        new Adjustment((InventoryItem)key,(Integer)vec).addStock();
                        new Adjustment((InventoryItem)k,(Integer)v).minusStock();
                    }
                });
            });
            System.out.println("You got back: " + Math.abs(tradOff.getSubtotal()-tradIn.getSubtotal()));
        }
        else{
            System.out.println("Even");
        }
        

    }

    @Override
    public void run() {
        maketransaction();
    }
    
}
