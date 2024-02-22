package model;

import java.util.ArrayList;
import java.util.List;

public class TravelPackage {

    private String name;
    private Integer capacity;
    List<Destination> destinationList;
    List<Passenger> passengerList;

    public TravelPackage(String name, Integer capacity) {
        this.name = name;
        this.capacity = capacity;
        this.destinationList= new ArrayList<>();
        this.passengerList = new ArrayList<>();
    }

    public void addDestination(Destination destination){
        destinationList.add(destination);
    }

    public void removeDestination(Destination destination){
        destinationList.remove(destination);
    }

    public void addPassenger(Passenger passenger){
        if(passengerList.size() <=capacity){
            passengerList.add(passenger);
        }
        else{
            System.out.println("No seats available for this travel package. Please try some other package");
        }
    }

    public void removePassenger(Passenger passenger){
        if(passengerList.contains(passenger)){
            passengerList.add(passenger);
        }
        else{
            System.out.println("Passenger not present.");
        }
    }

    public void printItinerary(){
        System.out.println("name:"+name);
        for(Destination destination : destinationList){
            System.out.println("Destination:"+destination.getName());
            System.out.println("List of Activities : ");
             for(Activity activity : destination.getActivityList()){
                 activity.printActivityDetails();
             }
        }
    }

    public void printPassengerList(){
        System.out.println("Travel package name:"+name);
        System.out.println("Passenger capacity:"+capacity);
        System.out.println("Number of passengers currently enrolled:"+passengerList.size());
        for(Passenger passenger : passengerList){
            System.out.println("Passenger name:"+passenger.getName());
            System.out.println("Passenger name:"+passenger.getNumber());
        }
    }

    int getAvailableCapacity(){
        return capacity- passengerList.size();
    }

    public void printAvailableActivities(){
        System.out.println("List of Activities available spaces : ");
        for(Destination destination : destinationList){
            System.out.println("For Destination:" + destination.getName());
            for(Activity activity : destination.getActivityList()){
                int spaceAvailable = activity.getSpacesAvailable();
                if(spaceAvailable>=0) {
                    activity.printActivityDetails();
                    System.out.println("Space available:" + spaceAvailable);
                    System.out.println();
                }
            }
        }
    }

}
