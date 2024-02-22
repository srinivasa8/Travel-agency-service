package service.Impl;

import model.Activity;
import model.Destination;
import model.GoldPassenger;
import model.Passenger;
import model.StandardPassenger;
import model.TravelPackage;
import service.TravelAgencyService;

import java.util.List;

public class TravelAgencyServiceImpl implements TravelAgencyService {

    @Override
    public void addDestination(Destination destination, TravelPackage travelPackage) {
        travelPackage.addDestination(destination);
    }

    @Override
    public void bookActivity(Passenger passenger, Activity activity) throws Exception {
        if (passenger == null || activity == null) return;
        if (passenger.canBuy(activity)) {
            passenger.buy(activity);
        } else {
            throw new Exception("You don't have sufficient balance to book this activity!");
        }
        if (activity.getSpacesAvailable() > 0) {
            activity.addPassenger(passenger);
        } else {
            throw new Exception("No spaces available for the activity :" + activity.getName());
        }
    }

    @Override
    public void bookTravelPackage(Passenger passenger, TravelPackage travelPackage) throws Exception {
        if (travelPackage == null || passenger == null) return;
        if (travelPackage.getSpacesAvailable() > 0) {
            travelPackage.addPassenger(passenger);
        } else {
            throw new Exception("No spaces available for the travel package :" + travelPackage.getName());
        }
    }

    @Override
    public void printItinerary(TravelPackage travelPackage) {
        if (travelPackage == null) return;
        System.out.println("Travel package name:" + travelPackage.getName());
        for (Destination destination : travelPackage.getDestinationList()) {
            System.out.println("Destination:" + destination.getName());
            System.out.println("List of Activities : ");
            for (Activity activity : destination.getActivityList()) {
                printActivityDetails(activity);
            }
        }
    }

    private void printActivityDetails(Activity activity) {
        System.out.println("Activity name: " + activity.getName());
        System.out.println("description: " + activity.getDescription());
        System.out.println("cost: " + activity.getCost());
        System.out.println("capacity: " + activity.getCapacity());
    }

    @Override
    public void printPassengerList(TravelPackage travelPackage) {
        if (travelPackage == null) return;
        System.out.println("Travel package name:" + travelPackage.getName());
        System.out.println("Passenger capacity:" + travelPackage.getCapacity());
        List<Passenger> passengerList = travelPackage.getPassengerList();
        System.out.println("Number of passengers currently enrolled:" + passengerList.size());
        for (Passenger passenger : travelPackage.getPassengerList()) {
            System.out.println("Passenger name:" + passenger.getName());
            System.out.println("Passenger number:" + passenger.getNumber());
        }
    }

    @Override
    public void printPassengerDetails(Passenger passenger) {
        if (passenger == null) return;
        System.out.println("Passenger name : " + passenger.getName());
        if (passenger instanceof StandardPassenger) {
            StandardPassenger standardPassenger = (StandardPassenger) passenger;
            System.out.println("Balance : " + standardPassenger.getBalance());
        }
        if (passenger instanceof GoldPassenger) {
            GoldPassenger goldPassenger = (GoldPassenger) passenger;
            System.out.println("Balance : " + goldPassenger.getBalance());
        }
        List<Activity> activityList = passenger.getSignedActivityList();
        if (!activityList.isEmpty()) {
            System.out.println("List of activities passenger has signed up for :");
            for (Activity activity : activityList) {
                System.out.println("Activity name : " + activity.getName());
                System.out.println("Destination : " + activity.getDestination().getName());
                System.out.println("Price paid : " + passenger.getAmount(activity));
            }
        } else {
            System.out.println("Passenger not signed up for any activities.");
        }
    }

    @Override
    public void printAvailableActivities(TravelPackage travelPackage) {
        if (travelPackage == null) return;
        System.out.println("List of Activities with available spaces : ");
        for (Destination destination : travelPackage.getDestinationList()) {
            System.out.println("For Destination:" + destination.getName());
            for (Activity activity : destination.getActivityList()) {
                int spaceAvailable = activity.getSpacesAvailable();
                if (spaceAvailable >= 0) {
                    printActivityDetails(activity);
                    System.out.println("Space available:" + spaceAvailable);
                    System.out.println();
                }
            }
        }
    }

}
