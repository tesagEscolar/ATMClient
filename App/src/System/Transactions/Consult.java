package App.src.System.Transactions;
import App.src.System.Operation;
import App.src.System.Transaction;

public class Consult implements Operation {
  public Consult(){
  }

  public void setParameters(Object ... getparams){
    new Transaction(this).setTransactionParameters(getparams).consult();
  }

    public String toString(){
    return Transactions.CONSULT.toString();
  }
  
}