package App.src.System.Transactions;
import App.src.System.Operation;
import App.src.System.Transaction;


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