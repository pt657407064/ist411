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
public class Withdraw extends Transaction implements Runnable {

    private double amount;
    private Account acc;
    public Withdraw(int tNumber,double amount,Account acc)
    {
        super(tNumber);
        this.amount = amount;
        this.acc = acc;
        
    }
    @Override
    public void makeTransAction() {
        
     if(acc.getBalance()< amount)
     {
         System.out.println("Not engough balance");
     }
     else{
         acc.setBalance(acc.getBalance()-amount);
         System.out.println(acc.getUserName() + " withdraw: "+ amount);
         System.out.println(acc.getUserName() + " Balance： "+ acc.getBalance());
         System.out.println();
         
     }
        

    }

    @Override
    public void run() {
        makeTransAction();
    }


}
