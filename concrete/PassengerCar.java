package concrete;

import abstracted.Vehicle;

public class PassengerCar extends Vehicle {
    private String type;
    private String name;
    private float packingPrice;

    public PassengerCar(String name, String type,  float packingPrice) {
        this.setName(name);
        this.setType(type);
        this.setPackingPrice(packingPrice);
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getType() {
        return type;
    }

    @Override
    public boolean equals(Object arg0) {
        return super.equals(arg0);
    }

    @Override
    public String toString() {
        return super.toString();
    }

    @Override
    public void setPackingPrice(float price) {
        this.packingPrice = price;

    }

    @Override
    public float getPackingPrice() {
        return packingPrice;
    }
    
}
