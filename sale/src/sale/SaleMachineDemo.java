/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sale;

import item.InventoryItem;
import java.util.ArrayList;

/**
 *
 * @author root
 */
public class SaleMachineDemo {

    /**
     * @param args the command line arguments
     */
    private static ArrayList<InventoryItem> InventoryItems = new ArrayList<>();
    public static void main(String[] args) throws InterruptedException {
        InventoryItem apple = new InventoryItem("Apple",0.8,1000);
        InventoryItems.add(apple);
        
        InventoryItem orange = new InventoryItem("Orange",0.3,1000);
        InventoryItems.add(orange);

        InventoryItem coke = new InventoryItem("Coke",0.75,1000);
        InventoryItems.add(coke);

        InventoryItem pepsi = new InventoryItem("Pepsi",0.8,1000);
        InventoryItems.add(pepsi);   
        
        
        
       /* SaleOrder saleOrder = new SaleOrder(102);
        saleOrder.addOrder(apple,10);
        saleOrder.addOrder(coke,10);
        saleOrder.addOrder(pepsi,10);
        saleOrder.addOrder(orange, 10);
        Sale sale = new Sale(saleOrder);
        Thread saleThread = new Thread(sale);
        saleThread.start();
        Thread.sleep(3000);
        InventoryItems.forEach(i->System.out.printf("%1s%10d%10.2f\n",i.getName(),i.getQuant(),i.getPrice()));
        */
      /*  ReturnOrder returnOrder = new ReturnOrder(103);
        returnOrder.addOrder(coke, 300);
        Return returns = new Return(returnOrder);
        
        Thread returnThread = new Thread(returns);
        returnThread.start();
        Thread.sleep(3000);
        InventoryItems.forEach(i->System.out.printf("%1s%10d%10.2f\n",i.getName(),i.getQuant(),i.getPrice()));
        */
        
        ReturnOrder tradIn = new ReturnOrder(104);
        tradIn.addOrder(coke, 20);
        SaleOrder tradOff = new SaleOrder(104);
        tradOff.addOrder(coke, 10);
        Exchange exchange = new Exchange(tradIn,tradOff);
        
        Thread exchangeThread = new Thread(exchange);
        
        
        exchangeThread.start();
        
        Thread.sleep(3000);
        InventoryItems.forEach(i->System.out.printf("%1s%10d%10.2f\n",i.getName(),i.getQuant(),i.getPrice()));

    }
    
}
