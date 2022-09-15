package LoginGUI.src.System.Transactions;
import LoginGUI.src.System.Operation;
import LoginGUI.src.System.Transaction;

public class Withdraw implements Operation {


  public Withdraw(){}

  public void setParameters(Object ... getparams) {
    new Transaction(this).setTransactionParameters(getparams).withdraw();
  }

    public String toString(){
    return Transactions.WITHDRAW.toString();
  }
}