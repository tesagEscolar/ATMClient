package App.src.System.Transactions;
import App.src.System.Operation;
import App.src.System.Transaction;

public class ChangeNip implements Operation {
  
  public ChangeNip(){
  }

  public void setParameters(Object ... getparams){
    new Transaction(this).setTransactionParameters(getparams).changeNip();
  }

    public String toString(){
    return Transactions.CHANGE_NIP.toString();
  }
  
}