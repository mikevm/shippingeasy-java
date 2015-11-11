package com.kowdley.shippingeasy.model;

import java.util.Vector;
import java.util.Calendar;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.FieldNamingPolicy;
import com.kowdley.shippingeasy.model.serializers.*;

public class Order {
  public String externalOrderIdentifier;
  public Calendar orderedAt;
  Vector<Recipient> recipients;
  public String totalIncludingTax;
  public String baseShippingCost;
  public String baseHandlingCost;

  public Order() {
    recipients = new Vector<Recipient>();
    orderedAt = Calendar.getInstance();
  }

  public Vector<Recipient> getRecipients() { return recipients; }
  public synchronized Order setRecipients(Vector<Recipient> recipients) {
    this.recipients = recipients;
    return this;
  }
  public synchronized Order setRecipient(Recipient recipient) {
    recipients.clear();
    recipients.add(recipient);
    return this;
  }
  public synchronized Order addRecipient(Recipient recipient) {
    recipients.add(recipient);
    return this;
  }

  public String getExternalOrderIdentifier() {
    return externalOrderIdentifier;
  }
  public Order setExternalOrderIdentifier(String externalOrderIdentifier) {
    this.externalOrderIdentifier = externalOrderIdentifier;
    return this;
  }

  public Calendar getOrderedat() { return orderedAt; }
  public Order setOrderedAt(Calendar orderedAt) {
    this.orderedAt = orderedAt;
    return this;
  }

  public String getTotalIncludingTax() { return totalIncludingTax; }
  public Order setTotalIncludingTax(float totalIncludingTax) {
    this.totalIncludingTax =
        new DecimalFormat("0.00").format(totalIncludingTax);
    return this;
  }

  public String getBaseShippingCost() { return baseShippingCost; }
  public Order setBaseShippingCost(BigDecimal baseShippingCost) {
    this.baseShippingCost = baseShippingCost.toString();
    return this;
  }

  public String getBaseHandlingCost() { return baseHandlingCost; }
  public Order setBaseHandlingCost(BigDecimal baseHandlingCost) {
    this.baseHandlingCost = baseHandlingCost.toString();
    return this;
  }

  public String toJson() {
    Gson gson = new GsonBuilder()
        .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
        .setPrettyPrinting()
        .registerTypeAdapter(Calendar.class, new CalendarSerializer())
        .registerTypeAdapter(java.util.GregorianCalendar.class, new CalendarSerializer())
        .create();
    return gson.toJson(this);
  }
}
