package LoginGUI.src.System;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

class HttpRequestSender {

  private static final String USER_AGENT = "Mozilla/5.0";
  private static String GET_URL = "https://BankServerFlask.tesag.repl.co/";
  private static final String GET_URL_BASE = "https://BankServerFlask.tesag.repl.co/";
  private static final String POST_URL = "https://localhost:9090/SpringMVCExample/home";
  private static final String POST_PARAMS = "";

  static void setGetParams(String[] keys, Object[] params) {
    GET_URL += "?";
    for (int i = 0; i < keys.length; i++) {
      GET_URL += keys[i] + "=" + params[i].toString() + "&";
    }
    GET_URL = GET_URL.substring(0, GET_URL.length() - 1);
  }

  static void setGetOperation(String Operation) {
    GET_URL += Operation.toLowerCase();
  }

  static void resetGETURL() {
    GET_URL = GET_URL_BASE;
  }

  static void sendGET() throws IOException {
    URL obj = new URL(GET_URL);
    HttpURLConnection con = (HttpURLConnection) obj.openConnection();
    con.setRequestMethod("GET");
    int responseCode = con.getResponseCode();

    if (responseCode == HttpURLConnection.HTTP_OK) { // success
      BufferedReader in = new BufferedReader(new InputStreamReader(
          con.getInputStream()));
      String inputLine;
      StringBuffer response = new StringBuffer();

      // Wait for request to process
      System.out.println("Cargando...");
      while ((inputLine = in.readLine()) != null) {
        response.append(inputLine);
      }
      in.close();
      // get response in Operation abstract class
      Transaction.response = response.toString();
    } else {
      Transaction.response = "-:Error de Conexion. Intente de Nuevo";
    }

  }

  private static void sendPOST() throws IOException {
    URL obj = new URL(POST_URL);
    HttpURLConnection con = (HttpURLConnection) obj.openConnection();
    con.setRequestMethod("POST");
    con.setRequestProperty("User-Agent", USER_AGENT);

    // For POST only - START
    con.setDoOutput(true);
    OutputStream os = con.getOutputStream();
    os.write(POST_PARAMS.getBytes());
    os.flush();
    os.close();
    // For POST only - END

    int responseCode = con.getResponseCode();
    System.out.println("POST Response Code :: " + responseCode);

    if (responseCode == HttpURLConnection.HTTP_OK) { // success
      BufferedReader in = new BufferedReader(new InputStreamReader(
          con.getInputStream()));
      String inputLine;
      StringBuffer response = new StringBuffer();

      while ((inputLine = in.readLine()) != null) {
        response.append(inputLine);
      }
      in.close();

      // print result
      System.out.println(response.toString());
    } else {
      System.out.println("POST request not worked");
    }
  }

}