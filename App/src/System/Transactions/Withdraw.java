package App.src.System.Transactions;
import App.src.System.Operation;
import App.src.System.Transaction;

public class Withdraw implements Operation {


  public Withdraw(){}

  public void setParameters(Object ... getparams) {
    new Transaction(this).setTransactionParameters(getparams).withdraw();
  }

    public String toString(){
    return Transactions.WITHDRAW.toString();
  }
}