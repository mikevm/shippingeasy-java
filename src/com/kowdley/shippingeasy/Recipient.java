package com.kowdley.shippingeasy;

import java.util.Vector;
import java.math.BigDecimal;

public class Recipient {
  public String firstName;
  public String lastName;
  Vector<LineItem> lineItems;

  public Recipient() {
    lineItems = new Vector<LineItem>();
  }
}
