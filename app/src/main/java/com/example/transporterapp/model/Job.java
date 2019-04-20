package com.example.transporterapp.model;

import com.google.gson.annotations.SerializedName;

import java.util.Date;

public class Job {

  @SerializedName("id")
  private int id;

  @SerializedName("origin")
  private String origin;

  @SerializedName("destination")
  private String destination;

  @SerializedName("date")
  private Date date;

  @SerializedName("price")
  private int price;

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getOrigin() {
    return origin;
  }

  public void setOrigin(String origin) {
    this.origin = origin;
  }

  public String getDestination() {
    return destination;
  }

  public void setDestination(String destination) {
    this.destination = destination;
  }

  public Date getDate() {
    return date;
  }

  public void setDate(Date date) {
    this.date = date;
  }

  public int getPrice() {
    return price;
  }

  public void setPrice(int price) {
    this.price = price;
  }
}
