package com.kowdley.shippingeasy.model;

import java.math.BigDecimal;

public class LineItem {
  protected String itemName;
  protected String sku;
  protected String binPickingNumber;
  protected BigDecimal unitPrice;
  protected BigDecimal totalExcludingTax;
  protected BigDecimal weightInOunces;
  protected Integer quantity;

  public String getItemName() { return itemName; }
  public LineItem setItemName(String itemName) {
    this.itemName = itemName;
    return this;
  }

  public String getSku() { return sku; }
  public LineItem setSku(String sku) {
    this.sku = sku;
    return this;
  }

  public String getBinPickingNumber() { return binPickingNumber; }
  public LineItem setBinPickingNumber(String bigPickingNumber) {
    this.binPickingNumber = binPickingNumber;
    return this;
  }

  public BigDecimal getUnitPrice() { return unitPrice; }
  public LineItem setUnitPrice(BigDecimal unitPrice) {
    this.unitPrice = unitPrice;
    return this;
  }

  public BigDecimal getTotalExcludingTax() { return totalExcludingTax; }
  public LineItem setTotalExcludingTax(BigDecimal totalExcludingTax) {
    this.totalExcludingTax = totalExcludingTax;
    return this;
  }

  public BigDecimal getWeightInOunces() { return weightInOunces; }
  public LineItem setWeightInOunces(float weightInOunces) {
    this.weightInOunces = new BigDecimal(weightInOunces);
    return this;
  }
  public LineItem setWeightInOunces(BigDecimal weightInOunces) {
    this.weightInOunces = weightInOunces;
    return this;
  }
 
  public Integer getQuantity() { return quantity; }
  public LineItem setQuantity(Integer quantity) {
    this.quantity = quantity;
    return this;
  }
}
