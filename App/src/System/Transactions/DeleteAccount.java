package App.src.System.Transactions;
import App.src.System.Operation;
import App.src.System.Transaction;


public class DeleteAccount implements Operation {

  public DeleteAccount(){

  }

  public void setParameters(Object ... getparams){
    new Transaction(this).setTransactionParameters(getparams).deleteAcount();
  }

    public String toString(){
    return Transactions.DELETE_ACCOUNT.toString();
  }
  
}