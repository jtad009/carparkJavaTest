import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

import Exceptions.CarParkSizeException;
import abstracted.Vehicle;
import concrete.Lorry;
import concrete.PassengerCar;

public class CarPark {

  
  private Vehicle parkingLot[];
  HashMap<String, Float> prices;
  private int allowedCarParkSize = 0;

  public CarPark(int size, HashMap<String, Float> priceList) {
    parkingLot = new Vehicle[size];
    prices = priceList;
    this.allowedCarParkSize = size;
  }

  /**
   * Park Car
   * 
   * @param Vehicle vehicle
   * @param int     i index at which to park
   * @return Vehicle[] parkingLot 
   */
  public Vehicle[] parkCar(Vehicle vehicle, int i) {

    try {
      return this.insertVehicleAtPosition(
          this.parkingLot,
          vehicle,
          i);
    } catch (CarParkSizeException e) {
      System.out.println("Error message: "+e.getMessage());
      System.out.println("Returning  carpark details ");
      System.out.println(this.toString());
      return this.parkingLot;
    }
  }

  public void parkPassengerCar(int number, PassengerCar vehicle) {
    this.parkCar(vehicle, number);
  }

  public void parkLorry(int number, Lorry vehicle) {
    this.parkCar(vehicle, number);
  }

  public Vehicle[] remove(int numberOfCar) throws CarParkSizeException {
  
    /**
     * Step 1: create a new carpark with reduced size
     * if carpark_size = 3
     * and you want to delete 2
     * the new Carpark would have a size of 3-2 =1
     * Vehicle[] newParklot  = new Vehicle[numberOfCar]; 
     * 
     * if carpark != null && numberOfCar < carpark.length:
     *    
     *      for(i = 0; i < carpark.length - numberOfCar ; i++);
     *          newArray[i] = carpark[i]
     *      endfor;
     *    else:
     *      print ("Error message")
     * endif;
     */


    
     Vehicle[] newParklot  = new Vehicle[this.parkingLot.length - numberOfCar];
      if(this.parkingLot != null && numberOfCar < this.parkingLot.length){
        for(int i = 0; i < this.parkingLot.length - numberOfCar ; i++){
          newParklot[i] = this.parkingLot[i];
        }
          this.parkingLot = newParklot;  
          System.out.println(this.toString());
      }else{
        throw new  CarParkSizeException("User is trying to remove more cars than allowed");
      }

    return this.parkingLot;
  }

  public Vehicle[] remove(Vehicle v) {
    return null;

  }

  public int vacantSpaces() {
    return 0;
  }

  /**
   * Insert Element at randome positions of an array
   * 
   * @param carpark array to copy
   * @param x   Element to add to array
   * @param pos new position
   * @return Vehicle[] vehicle
   */
  public Vehicle[] insertVehicleAtPosition(Vehicle carpark[],
      Vehicle x, int pos) throws CarParkSizeException {

    if (carpark != null && pos == this.allowedCarParkSize+1  ) {
      throw new CarParkSizeException("Parking spacing cannot exceed "+this.allowedCarParkSize);
    }
    
    // insert the elements from
    // the old array into the new array
    // insert all elements till pos
    // then insert x at pos
    // then insert rest of the elements
    List<Vehicle> list = new ArrayList<>(
        Arrays.asList(carpark));

    // Adding the element at position
    list.add(pos == 0 ? 0 : pos - 1, x);

    // Converting the list back to array
    // create and array stream
    // filter all no Null objects
    // return a new array of type Vehicles
    carpark = Arrays.stream(list.toArray(carpark)).filter(Objects::nonNull).toArray(Vehicle[]::new);
    
    // Printing the original array
    this.parkingLot = carpark;
    return carpark;
  }

  public int getParkingLotLength(){
    return this.parkingLot.length;
  }
  public Vehicle[] getParkingLot(){
    return this.parkingLot;
  }
  @Override
  public String toString() {
    String information = "";
    int index = 0;
      for (Vehicle vehicle : parkingLot) {
        index++;
        information += index +".";
          information += " "+vehicle.getName();
          information += " "+vehicle.getType();
          information += " "+vehicle.getPackingPrice()+"\n";

      }
      return information;
  }
}
