package LoginGUI.src.System;
import java.io.IOException;


public interface Operation{  
  
  public default boolean validateResponse(){       
    return Transaction.response.substring(0, 1).equals("+");
  }

  public default String getResponseContext(){
    return Transaction.response.substring(2);
  }

  private void setGetParams(){
    HttpRequestSender.setGetParams(Transaction.keys, Transaction.params);
  }
  
  private void setGetOperation(){
    HttpRequestSender.setGetOperation(Transaction.operation);
  }

  public void setParameters(Object ... getparams);
  
  public default void executeOperation(){
    this.setGetOperation();
    this.setGetParams(); 
     try{
        HttpRequestSender.sendGET();
      }catch(IOException e){
        System.out.println("Exception thrown for IO exception" + e);
      }
    HttpRequestSender.resetGETURL();
  };
}