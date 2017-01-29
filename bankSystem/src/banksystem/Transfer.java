/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package banksystem;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author root
 */
public class Transfer extends Transaction implements Runnable {
    
    private double amount;
    private Account sender;
    private Account receiver;
    public Transfer(int tnumber,double amount,Account sender,Account receiver) {
        super(tnumber);
        this.amount = amount;
        this.sender = sender;
        this.receiver = receiver;
        
    }

    @Override
    public void makeTransAction() {
        if(amount > sender.getBalance())
        {
            System.out.println("You do not have enought balance");
            
        }
        else{
            try {
                sender.setBalance(sender.getBalance()-amount);
                System.out.println("Transfer $" +amount +" from"+ sender.getUserName()+ " to " + receiver.getUserName());
                System.out.println("Processing your transaction...");
                Thread.sleep(3000);
                receiver.setBalance(sender.getBalance()+amount);
                System.out.println("Transaction completed");
                
                
                System.out.println(sender.getUserName()+"balance:"+ sender.getBalance());
                System.out.println(receiver.getUserName() +" balance:"+ receiver.getBalance());
            } catch (InterruptedException ex) {
                System.out.println("Thread has been interrputed");
            }
        }
    }

    @Override
    public void run() {
         makeTransAction();
    }
    
}
