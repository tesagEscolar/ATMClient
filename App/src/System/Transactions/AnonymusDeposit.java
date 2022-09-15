package App.src.System.Transactions;

import App.src.System.Operation;
import App.src.System.Transaction;


public class AnonymusDeposit implements Operation {

  public AnonymusDeposit() {
  }

  public void setParameters(Object... getparams) {
    new Transaction(this).setTransactionParameters(getparams).anonymusDeposit();
  }

  public String toString() {
    return Transactions.DEPOSIT.toString();
  }
}