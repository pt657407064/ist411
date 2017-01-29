/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package banksystem;

/**
 *
 * @author root
 */
public class Deposit extends Transaction implements Runnable {

    private double amount;
    private Account acc;
    public Deposit(int tnumber,double amount, Account acc) {
        super(tnumber);
        this.amount = amount;
        this.acc = acc;
        
    }

    @Override
    public void makeTransAction() {
       acc.setBalance(acc.getBalance()+amount);
       System.out.println(acc.getUserName() +" Deposit: "+ amount);
       System.out.println(acc.getUserName() +" Balace： "+ acc.getBalance());
       System.out.println();
    }

    @Override
    public void run() {
        makeTransAction();
    }
    
}
