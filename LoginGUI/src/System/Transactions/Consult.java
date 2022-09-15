package LoginGUI.src.System.Transactions;
import LoginGUI.src.System.Operation;
import LoginGUI.src.System.Transaction;

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