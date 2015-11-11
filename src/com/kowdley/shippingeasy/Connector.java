package com.kowdley.shippingeasy;

import com.kowdley.shippingeasy.model.*;
import java.io.DataInputStream;
import java.net.URL;
import java.net.URLConnection;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

public class Connector {
  private String apiKey;
  private String storeKey;
  private String apiSecret;
  private Order order;

  public Connector(String apiKey, String storeKey, String apiSecret) {
    this.apiKey = apiKey;
    this.storeKey = storeKey;
    this.apiSecret = apiSecret;
  }

  public Order getOrder() { return order; }
  public Connector setOrder(Order order) {
    this.order = order;
    return this;
  }

  public String getJson() {
    if (order == null) {
      throw new IllegalStateException("Cannot get JSON for order when order has not been set.");
    }
    return "{ \"order\": " + order.toJson() + " }";
  }

  public String postOrder() throws java.net.MalformedURLException,
                                   java.io.UnsupportedEncodingException,
                                   java.io.IOException,
                                   java.net.ProtocolException,
                                   java.security.NoSuchAlgorithmException,
                                   java.security.InvalidKeyException {
    String json = getJson();
    byte[] jsonBytes = json.getBytes("UTF-8");
    long unixTime = System.currentTimeMillis() / 1000L;

    Mac sha256_HMAC = Mac.getInstance("HmacSHA256");
    SecretKeySpec secretKey = new SecretKeySpec(apiSecret.getBytes(), "HmacSHA256");
    sha256_HMAC.init(secretKey);
    String text = "POST&/api/stores/" + storeKey + "/orders&api_key=" + apiKey + "&api_timestamp=" + unixTime + "&" + json;
    byte[] hash = sha256_HMAC.doFinal(text.getBytes());
    String check = bytesToHex(hash);

    URL url = new URL("https://app.shippingeasy.com/api/stores/" + storeKey + "/orders?api_key=" + apiKey + "&api_timestamp=" + unixTime + "&api_signature=" + check);

    URLConnection conn = url.openConnection();
    conn.setDoOutput(true);
    conn.setDoInput(true);
    conn.setRequestProperty("Content-length", String.valueOf(jsonBytes.length));
    java.io.OutputStream output = new java.io.BufferedOutputStream(conn.getOutputStream());
    output.write(jsonBytes);
    output.close();
    DataInputStream input = new DataInputStream(conn.getInputStream() ); 
    StringBuffer buf = new StringBuffer();
    for (int c = input.read(); c != -1; c = input.read())  {
      buf.append((char) c);
    }
    input.close(); 
    return buf.toString();
  }

  public static String bytesToHex(byte[] in) {
    final StringBuilder builder = new StringBuilder();
    for(byte b : in) {
      builder.append(String.format("%02x", b));
    }
    return builder.toString();
  }

}
