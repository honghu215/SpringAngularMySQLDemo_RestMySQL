package com.springmysql.demo.model;


import javax.persistence.*;

@Entity
@Table(name = "stock")
public class Stock {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long stock_id;

    @Column(name = "stock_name")
    private String stock_name;

    @Column(name = "stock_price")
    private double stock_price;

    @Column(name = "stock_field")
    private String stock_field;

    public Stock() {}

    public Stock(String stockname, double stockprice, String stockfield) {
        stock_name = stockname;
        stock_price = stockprice;
        stock_field = stockfield;
    }

    public long getStock_id() {
        return stock_id;
    }

    public String getStock_name() {
        return stock_name;
    }

    public double getStock_price() {
        return stock_price;
    }

    public String getStock_field() {
        return stock_field;
    }

    public void setStock_name(String stock_name) {
        this.stock_name = stock_name;
    }

    public void setStock_price(double stock_price) {
        this.stock_price = stock_price;
    }

    public void setStock_field(String stock_field) {
        this.stock_field = stock_field;
    }

    @Override
    public String toString() {
        return "Stock{" +
                "stock_id=" + stock_id +
                ", stock_name='" + stock_name + '\'' +
                ", stock_price=" + stock_price +
                ", stock_field='" + stock_field + '\'' +
                '}';
    }
}
