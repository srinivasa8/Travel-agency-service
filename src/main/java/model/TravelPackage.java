package model;

import java.util.ArrayList;
import java.util.List;

public class TravelPackage {

    private String name;
    private Integer capacity;
    private List<Destination> destinationList;
    private List<Passenger> passengerList;

    public TravelPackage(String name, Integer capacity) {
        this.name = name;
        this.capacity = capacity;
        this.destinationList= new ArrayList<>();
        this.passengerList = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }

    public List<Destination> getDestinationList() {
        return destinationList;
    }

    public void setDestinationList(List<Destination> destinationList) {
        this.destinationList = destinationList;
    }

    public List<Passenger> getPassengerList() {
        return passengerList;
    }

    public void setPassengerList(List<Passenger> passengerList) {
        this.passengerList = passengerList;
    }

    public void addDestination(Destination destination){
        destinationList.add(destination);
    }

    public void addPassenger(Passenger passenger){
        passengerList.add(passenger);
    }

    public int getSpacesAvailable(){
        return capacity - passengerList.size();
    }

}
