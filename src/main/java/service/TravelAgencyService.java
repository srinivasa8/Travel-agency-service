package service;

import model.Activity;
import model.Destination;
import model.Passenger;
import model.TravelPackage;

public interface TravelAgencyService {

    void addDestination(Destination destination, TravelPackage travelPackage);

    void bookTravelPackage(Passenger passenger, TravelPackage travelPackage) throws Exception;

    void bookActivity(Passenger passenger, Activity activity) throws Exception;

    void printItinerary(TravelPackage travelPackage);

    void printPassengerList(TravelPackage travelPackage);

    void printAvailableActivities(TravelPackage travelPackage);

    void printSignedActivityList(Passenger passenger);

}
