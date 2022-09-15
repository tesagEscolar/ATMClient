package LoginGUI.src.System.Transactions;

import LoginGUI.src.System.Operation;
import LoginGUI.src.System.Transaction;


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