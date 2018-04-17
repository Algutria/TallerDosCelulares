package com.tallerdosclases.tallerdosclase;

public class Phone {
    private String brand;
    private String color;
    private Double price;

    public Phone(String brand, String color, Double price) {
        this.brand = brand;
        this.color = color;
        this.price = price;
    }

    public String getBrand() {
        return brand;
    }

    public String getColor() {
        return color;
    }

    public Double getPrice() {
        return price;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public void save(){
        Data.savePhone(this);
    }
}
