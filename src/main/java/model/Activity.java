package model;

import java.util.ArrayList;
import java.util.List;

public class Activity {

    private String name;
    private String description;
    private double cost;
    private Integer capacity;
    private Destination destination;
    private List<Passenger> passengerList;

    public Activity(String name, String description, double cost, Integer capacity, Destination destination) {
        this.name = name;
        this.description = description;
        this.cost = cost;
        this.capacity = capacity;
        this.destination = destination;
        this.passengerList=new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }

    public Destination getDestination() {
        return destination;
    }

    public void setDestination(Destination destination) {
        this.destination = destination;
    }

    public List<Passenger> getPassengerList() {
        return passengerList;
    }

    public void setPassengerList(List<Passenger> passengerList) {
        this.passengerList = passengerList;
    }

    public void printActivityDetails() {
        System.out.println("Activity name: "+ name);
        System.out.println("description: "+ description);
        System.out.println("cost: "+ cost);
        System.out.println("capacity: "+ cost);
    }


    public int getSpacesAvailable(){
        return capacity - passengerList.size();
    }

    public void addPassenger(Passenger passenger){
        passengerList.add(passenger);
    }

}
