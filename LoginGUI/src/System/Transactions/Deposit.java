package LoginGUI.src.System.Transactions;

import LoginGUI.src.System.Operation;
import LoginGUI.src.System.Transaction;

public class Deposit implements Operation {

  public Deposit() {
  }

  public void setParameters(Object ... getparams) {
    new Transaction(this).setTransactionParameters(getparams).deposit();
  }

  public String toString(){
    return  Transactions.DEPOSIT.toString();
  }
}