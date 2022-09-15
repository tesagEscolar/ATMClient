package LoginGUI.src.System.Transactions;
import LoginGUI.src.System.Operation;
import LoginGUI.src.System.Transaction;


public class Transfer implements Operation {

  public Transfer(){
  }

  public void setParameters(Object ... getparams) {
    new Transaction(this).setTransactionParameters(getparams).transfer();
  }
  
  public String toString(){
    return Transactions.TRANSFER.toString();
  }
}