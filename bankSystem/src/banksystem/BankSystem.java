
package banksystem;

/**
 *
 * @author root
 */
public class BankSystem{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
      Account tao = new Account("tao",5000);
      System.out.println("Balance： " + tao.getBalance());
      Account pan = new Account("pan", 6000);
      
      
      
      Deposit deposit = new Deposit(102,200,tao);
      Thread depositThread = new Thread(deposit);

      
      Withdraw w = new Withdraw(101,200,tao);
      Thread withdrawThread = new Thread(w);
      
      
      Transfer t = new Transfer(101,300,tao,pan);
      Thread transactionThread = new Thread(t);
      
      withdrawThread.start();
      depositThread.start();
      transactionThread.start();
      
      
      
    }
    

    
}
