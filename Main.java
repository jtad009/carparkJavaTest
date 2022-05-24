
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Stream;

import Exceptions.CarParkSizeException;
import concrete.Lorry;
import concrete.PassengerCar;

public class Main {
    String[] options = { "1. Add car parks", "2. Park Passenger Car", "3. Remove Passenger Car", "4. Park Lorry Car", "5. Remove Lorry Car","6. Exit" };
    Scanner sc = null;
    CarPark userCarPark = null;
    HashMap<String, CarPark> map = null;

    HashMap<String, Float> price = null;
    Stream<String> stream = null;

    private static final String LORRY="Lorry";  
    private static final String PASSENGER="Passenger";  

    /**
     * Algorithm for the application
     * 1. Start Application
     * 2.
     */
    public Main() {
        price = new HashMap<String, Float>();
        sc = new Scanner(System.in);
        this.map = new HashMap<String, CarPark>();

    }

    /**
     * This function is used to read and interpert user input
     * 
     * @param Object object representing user input
     * @return null
     * {
     *  "key" : value
     * "Lorry": CarPark,
     * "Passenger" : CarPark
     * }
     */
    public void readKey(Object option) {
        String inputKey = String.valueOf(option).toLowerCase();
        switch (inputKey) {
            case "6":
                System.out.println("Closing Application...");
                System.exit(0);

                break;
            case "2":
                System.out.println("User Wants to park car in the parking lot");
                this.doPark();
                break;
            case "3":
                System.out.println("User Wants to remove Passenger car from the parking lot");
                try {
                    this.map.get(PASSENGER).remove(3);
                } catch (CarParkSizeException e) {
                    System.out.println("Error message: "+e.getMessage());
                    e.printStackTrace();
                }
                break;
            case "1":
                System.out.println("Creating car park");
                this.addCarParkSpace();
                break;
            case "4":
                this.parkLorry();
                break;
            case "5":
                System.out.println("Creating car park");
                try {
                    this.map.get(LORRY).remove(2);
                } catch (CarParkSizeException e) {
                    System.out.println("Error message: "+e.getMessage());
                }
                break;
            case "lorry":
                System.out.println("Lorry Selected");
                this.parkLorry();
                break;
            default:
        }
        this.printMenu();
    }

    public void init() {
        if (this.sc != null) {

            System.out.println("******************************************");
            System.out.println("   Welcome to the car park program    ");
            System.out.println("******************************************");

            this.addCarParkSpace();

            System.out.println("******************************************");
            System.out.println("   Done Initalizing Car   ");
            System.out.println("******************************************");

            this.printMenu();
            System.out.println("    ");
            int userSelection = 0;
            while (this.sc.hasNext()) {
                userSelection = this.sc.nextInt();
                this.readKey(userSelection);
            }

        }
    }

    public void printMenu() {
        System.out.println("\n******************************************");

        System.out.println("   Select from the options   ");
        System.out.println("   Select from the menu by inputing a number   ");
        System.out.println("******************************************");
        Stream<String> stream = Arrays.stream(options);
        stream
                .forEach(str -> System.out.println(str + ""));
    }

    public static void main(String[] args) {
        Main m = new Main();
        m.init();
    }

    private void doPark() {
        int nextIndex = 0;
        if (userCarPark.getParkingLot()[0] != null) {
            nextIndex = userCarPark.getParkingLotLength() + 1;
        }
        if(this.map.get(PASSENGER) != null){
            this.map.get(PASSENGER)
            .parkCar(
                new PassengerCar("Mercedez Benz", PASSENGER, this.map.get(PASSENGER).prices.get(PASSENGER)), 
                nextIndex);
        }else{
            System.out.println(MessageFormat.format("{0} park does not exist ", PASSENGER));
        } 
    }

    private void parkLorry() {
        int nextIndex = 0;
        if (userCarPark.getParkingLot()[0] != null) {
            nextIndex = userCarPark.getParkingLotLength() + 1;
        }
        if(this.map.get(LORRY) != null){
        this.map.get(LORRY)
        .parkLorry(nextIndex, new Lorry("Tundra", LORRY, this.map.get(LORRY).prices.get(LORRY))); 
        }else{
            System.out.println(MessageFormat.format("{0} park does not exist ", LORRY));
        }
    }

    private void addCarParkSpace() {
        if (this.sc != null) {
            System.out.print("Please enter Carpark size to be created: ");
            int carparkSize = sc.nextInt();
            // this.readKey(carparkSize);

            System.out.print("Please enter Car type: ");
            String carType1 = this.sc.next().toString();
            // this.readKey(carType1);

            System.out.print(String.format("Enter price for %s: ", carType1));
            float carTypePrice1 = this.sc.nextFloat();
            // this.readKey(carTypePrice1);

            this.price.put(carType1, carTypePrice1);
            userCarPark = new CarPark(carparkSize, price);
            this.map.put(carType1, userCarPark);

            this.map.forEach((k, v) -> {

                System.out.println("\n" + k + " Park created.");
                v.prices.forEach((key, val) -> {
                    
                    if(key == k )
                    System.out.println("\nAllowed Car Type: " + key + ",  Parking Cost: " + val + "\n") ;
                });
            });
        }
    }

    @Override
    public String toString() {
        String information = "";

        return information;
    }
}