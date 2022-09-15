package App.src.System;


public class Transaction {
  static Object[] params;
  static String[] keys;
  static String operation;
  static String response;

  public Transaction(Operation transoperation) {
    operation = transoperation.toString();
  }

  public Transaction setTransactionParameters(Object[] transParams) {
    params = transParams;
    return this;
  }

  public void changeNip(){
    keys =  new String[] {"accountid","nip", "new_nip"};
  }

  public void consult(){
    keys =  new String[] {"accountid", "nip"};
  }
  
  public void createAcount(){
    keys =  new String[] {"accountid", "nip"};
  }
  
  public void deleteAcount(){
    keys =  new String[] {"accountid", "nip"};
  }
  
  public void deposit(){
    keys = new String[] {"accountid","nip", "amount"};
  }
  
  public void anonymusDeposit(){
    keys = new String[] {"random","nip", "amount", "accountid"};
  }
  
  public void transfer() {
    keys = new String[] { "sender", "nip", "amount", "getter" };
  }
  
  public void withdraw() {
    keys = new String[] {"accountid","nip", "amount"}; 
  }
}