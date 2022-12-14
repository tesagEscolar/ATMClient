package App.src.System.Transactions;

import App.src.System.Operation;
import App.src.System.Transaction;

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