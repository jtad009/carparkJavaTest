package abstracted;

public abstract class Vehicle{
    String type;
    String name;
    float packingPrice;
    
    public abstract void setName(String name);
    public abstract String getName();
    public abstract void setType(String type);
    public abstract String getType();
    public abstract void setPackingPrice(float price);
    public abstract float getPackingPrice();
}

