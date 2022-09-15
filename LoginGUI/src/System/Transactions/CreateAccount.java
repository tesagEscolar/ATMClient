package LoginGUI.src.System.Transactions;
import LoginGUI.src.System.Operation;
import LoginGUI.src.System.Transaction;

public class CreateAccount implements Operation {
  private String username;

  public CreateAccount(){
  }

  public void setParameters(Object ... getparams){
  new Transaction(this).setTransactionParameters(getparams).createAcount();
  }

    public String toString(){
    return Transactions.NEW_ACCOUNT.toString();
  }
}