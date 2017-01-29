package banksystem;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author root
 */
public abstract class Transaction {
   protected int transNum;
   protected Account receiver;
    public Transaction(int tnumber)
    {
        this.transNum = tnumber;
    }
    

   public abstract void makeTransAction();
   
    
}
