package concrete;

import abstracted.Vehicle;

public class Lorry extends Vehicle {

    private String type;
    private String name;
    private float packingPrice;

    public Lorry(String name, String type, float parkingPrice) {
        this.setName(name);
        this.setType(type);
        this.setPackingPrice(parkingPrice);
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
    public void setPackingPrice(float price) {
        packingPrice = price;

    }

    @Override
    public float getPackingPrice() {
        return packingPrice;
    }
}
