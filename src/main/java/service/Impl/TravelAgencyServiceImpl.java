package service.Impl;

import model.Activity;
import model.Destination;
import model.GoldPassenger;
import model.Passenger;
import model.StandardPassenger;
import model.TravelPackage;
import repositories.TravelPackageRepository;
import service.TravelAgencyService;

import java.util.List;

public class TravelAgencyServiceImpl implements TravelAgencyService {

    private final TravelPackageRepository travelPackageRepository;

    public TravelAgencyServiceImpl() {
        this.travelPackageRepository = new TravelPackageRepository();
    }

    @Override
    public void createTravelPackage(TravelPackage travelPackage) throws Exception {
        if (travelPackage == null) throw new Exception("Travel package name can't be null");
        travelPackageRepository.createTravelPackage(travelPackage);
    }

    @Override
    public void updateTravelPackage(TravelPackage travelPackage) throws Exception {
        if (travelPackage == null) throw new Exception("Travel package name can't be null");
        travelPackageRepository.updateTravelPackage(travelPackage);
    }

    @Override
    public void addDestinationToTravelPackage(Destination destination, String travelPackageName) throws Exception {
        if (destination == null || travelPackageName == null || travelPackageName.isEmpty())
            throw new Exception("Invalid input!");
        travelPackageRepository.addDestinationToTravelPackage(destination, travelPackageName);
    }

    @Override
    public void bookActivity(Passenger passenger, Activity activity) throws Exception {
        if (passenger == null || activity == null) throw new Exception("Invalid Input!");
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
    public void bookTravelPackage(Passenger passenger, String travelPackageName) throws Exception {
        if (travelPackageName == null || travelPackageName.isEmpty()) throw new Exception("Invalid input!");
        TravelPackage travelPackage = travelPackageRepository.getTravelPackageByName(travelPackageName);
        if (travelPackage.getSpacesAvailable() > 0) {
            travelPackageRepository.addPassengerToTravelPackage(passenger, travelPackageName);
        } else {
            throw new Exception("No spaces available for the travel package :" + travelPackage.getName());
        }
    }

    @Override
    public void printItinerary(String travelPackageName) throws Exception {
        if (travelPackageName == null || travelPackageName.isEmpty()) throw new Exception("Invalid input!");
        System.out.println("LIST OF DESTINATIONS(ITINERARY) FOR: " + travelPackageName);
        List<Destination> destinationList = travelPackageRepository.getDestinationByTravelPackageName(travelPackageName);
        System.out.println("Travel package name: " + travelPackageName);
        for (Destination destination : destinationList) {
            List<Activity> activityList = destination.getActivityList();
            if (!activityList.isEmpty()) {
                System.out.println("Destination: " + destination.getName());
                System.out.println("List of Activities: ");
                for (Activity activity : activityList) {
                    printActivityDetails(activity);
                    System.out.println();
                }
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
    public void printPassengerList(String travelPackageName) throws Exception {
        if (travelPackageName == null || travelPackageName.isEmpty()) throw new Exception("Invalid input!");
        System.out.println("LIST OF PASSENGERS FOR: " + travelPackageName);
        TravelPackage travelPackage = travelPackageRepository.getTravelPackageByName(travelPackageName);
        System.out.println("Travel package name:" + travelPackageName);
        System.out.println("Passenger capacity: " + travelPackage.getCapacity());
        List<Passenger> passengerList = travelPackage.getPassengerList();
        System.out.println("Number of passengers currently enrolled: " + passengerList.size());
        for (Passenger passenger : travelPackage.getPassengerList()) {
            System.out.println("Passenger name: " + passenger.getName());
            System.out.println("Passenger number: " + passenger.getNumber());
        }
    }

    @Override
    public void printPassengerDetails(Passenger passenger) {
        if (passenger == null) return;
        System.out.println("PASSENGER DETAILS: ");
        System.out.println("Passenger name: " + passenger.getName());
        if (passenger instanceof StandardPassenger) {
            StandardPassenger standardPassenger = (StandardPassenger) passenger;
            System.out.println("Balance: " + standardPassenger.getBalance());
        }
        if (passenger instanceof GoldPassenger) {
            GoldPassenger goldPassenger = (GoldPassenger) passenger;
            System.out.println("Balance: " + goldPassenger.getBalance());
        }
        List<Activity> activityList = passenger.getSignedActivityList();
        if (!activityList.isEmpty()) {
            System.out.println("List of activities passenger has signed up for :");
            for (Activity activity : activityList) {
                System.out.println("Activity name: " + activity.getName());
                System.out.println("Destination: " + activity.getDestination().getName());
                System.out.println("Price paid: " + passenger.getAmount(activity));
            }
        } else {
            System.out.println("Passenger not signed up for any activities.");
        }
    }

    @Override
    public void printAvailableActivities(String travelPackageName) throws Exception {
        if (travelPackageName == null || travelPackageName.isEmpty()) throw new Exception("Invalid input!");
        System.out.println("LIST OF ACTIVITIES WITH AVAILABLE SPACES: ");
        List<Destination> destinationList = travelPackageRepository.getDestinationByTravelPackageName(travelPackageName);
        for (Destination destination : destinationList) {
            List<Activity> activityList = destination.getActivityList();
            if (!activityList.isEmpty()) {
                System.out.println("For Destination:" + destination.getName());
                for (Activity activity : activityList) {
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

}
