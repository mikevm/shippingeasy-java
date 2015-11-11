package com.kowdley.shippingeasy.model;

import java.util.Vector;
import java.math.BigDecimal;

public class Recipient {
  public String firstName;
  public String lastName;
  Vector<LineItem> lineItems;
  public String address;
  public String address2;
  public String city;
  public String state;
  public String postalCode;
  public String country;
  public String email;

  public Recipient() {
    lineItems = new Vector<LineItem>();
  }

  public String getFirstName() { return firstName; }
  public Recipient setFirstName(String firstName) {
    this.firstName = firstName;
    return this;
  }

  public String getLastName() { return lastName; }
  public Recipient setLastName(String lastName) {
    this.lastName = lastName;
    return this;
  }

  public Vector<LineItem> getLineItems() { return lineItems; }
  public Recipient setLineItems(Vector<LineItem> lineItems) {
    this.lineItems = lineItems;
    return this;
  }

  public String getAddress() { return address; }
  public Recipient setAddress(String address) {
    this.address = address;
    return this;
  }

  public String getAddress2() { return address2; }
  public Recipient setAddress2(String address2) {
    this.address2 = address2;
    return this;
  }

  public String getCity() { return city; }
  public Recipient setCity(String city) {
    this.city = city;
    return this;
  }

  public String getState() { return state; }
  public Recipient setState(String state) {
    this.state = state;
    return this;
  }

  public String getPostalCode() { return postalCode; }
  public Recipient setZip(String postalCode) {
    this.postalCode = postalCode;
    return this;
  }

  public String getCountry() { return country; }
  public Recipient setCountry(String country) {
    this.country = country;
    return this;
  }

  public String getEmail() { return email; }
  public Recipient setEmail(String email) {
    this.email = email;
    return this;
  }

}
