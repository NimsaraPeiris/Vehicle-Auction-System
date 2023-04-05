// This code can make vehicles for bid, show which vehicles in the system for bid, and know the winners after add the bid. 
// also we can add the base price of the vehicle when we adding the vehicle to the system
import java.util.*;

public class VehicleAuctionSystem {

    static class Vehicle {
        String make;
        double currentBid;

        Vehicle(String make, double currentBid) {
            this.make = make;
            this.currentBid = currentBid;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Vehicle> vehicles = new ArrayList<>(); //create a array list

        while (true) { //display options as a text
            System.out.println("Please select an option:");
            System.out.println("1. Add a vehicle");
            System.out.println("2. List vehicles");
            System.out.println("3. Bid on a vehicle");
            System.out.println("4. Exit");

            int choice = scanner.nextInt(); //get inputs

            switch (choice) { //make choices using switch
                case 1 -> {
                    System.out.print("Enter the name of the vehicle: ");
                    String make = scanner.next();
                    System.out.print("Enter the starting bid: ");
                    double startingBid = scanner.nextDouble();
                    vehicles.add(new Vehicle(make, startingBid));
                }
                case 2 -> {
                    System.out.println("List of available vehicles:");
                    for (Vehicle vehicle : vehicles) {
                        System.out.println(vehicle.make + " - Current Bid: " + vehicle.currentBid);
                    }
                }
                case 3 -> {
                    System.out.print("Enter the make of the vehicle you want to bid on: ");
                    String bidMake = scanner.next();
                    System.out.print("Enter your bid: ");
                    double bidAmount = scanner.nextDouble();
                    for (Vehicle vehicle : vehicles) {
                        if (vehicle.make.equals(bidMake)) {
                            if (bidAmount > vehicle.currentBid) {
                                vehicle.currentBid = bidAmount;
                                System.out.println("Congratulations! You are now the highest bidder for the " + vehicle.make + ".");
                            } else {
                                System.out.println("Sorry, your bid was not high enough. The current highest bid for " + vehicle.make + " is " + vehicle.currentBid);
                            }
                            break;
                        }
                    }
                }
                case 4 -> {
                    System.out.println("Thank you for using the Vehicle Auction System!");
                    System.exit(0);
                }
                default -> System.out.println("Invalid option. Please try again.");
            }
        }
    }
} //I think there's not such things to explain with comments, I just used switch method and some objects for store particular data

