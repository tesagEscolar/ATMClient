package App.src.System;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.nio.charset.StandardCharsets;
import java.security.NoSuchAlgorithmException;
import App.src.System.Transactions.CreateAccount;

public class User {
  private String username;
  private String anonymusNip;
  private static User user = new User();
  private String responseContext;
  private boolean cardMovement;
  private boolean state;
  
  private User(){}
  
  public static User getUser(){
    return user;
  }

  public boolean isCardMovement(){
    return this.cardMovement;
  }
  
  public void setUser(boolean cardMovement, String username, int nip){
    user.cardMovement = cardMovement;
    user.username = username.toLowerCase();
    user.createAccount(setNip(nip));
  }

  public void setUser(boolean cardMovement, String username){
    user.cardMovement = cardMovement;
    user.anonymusNip = "-1";
    user.username = username.toLowerCase();
    user.createAccount(anonymusNip);
  }
 
  public String getUsername(){
    return user.username;
  }

  public boolean getUserState(){
    return this.state;
  }
  
  public String getResponseContext(){
    return this.responseContext;
  }
  
  static public String setNip(int nip){
    var number = Integer.toString(nip);
    try{
      return toHexString(getSHA(number));
    }
    catch(NoSuchAlgorithmException e){
        System.out.println("Exception thrown for incorrect algorithm: " + e);
        return "0";
    }
  }
  
  private static byte[] getSHA(String input) throws NoSuchAlgorithmException{
        // Static getInstance method is called with hashing SHA
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        // digest() method called
        // to calculate message digest of an input
        // and return array of byte
        return md.digest(input.getBytes(StandardCharsets.UTF_8));
    }
     
  private static String toHexString(byte[] hash){
        // Convert byte array into signum representation
        BigInteger number = new BigInteger(1, hash);
      
        // Convert message digest into hex value
        StringBuilder hexString = new StringBuilder(number.toString(16));
 
        // Pad with leading zeros
        while (hexString.length() < 64)
        {
            hexString.insert(0, '0');
        }
 
        return hexString.toString();
    }  
  
  private void createAccount(String hashNip){
      Operation operation = new CreateAccount();
      operation.setParameters(user.username, hashNip);
      operation.executeOperation();
      this.responseContext = operation.getResponseContext();
      this.state = operation.validateResponse();
    }

}