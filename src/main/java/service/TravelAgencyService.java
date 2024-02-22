package service;

import model.Activity;
import model.Destination;
import model.Passenger;
import model.TravelPackage;

public interface TravelAgencyService {

    /**
     * Adds the requested destination to the travel package.
     *
     * @param destination The destination to be added. Must not be null. if null, the method has no effect.
     * @param travelPackage The travel package to which the destination will be added. Must not be null. if null, the method has no effect.
     */
    void addDestination(Destination destination, TravelPackage travelPackage);

    /**
     * Books the requested travelPackage for the passenger.
     *
     * @Param passenger The Passenger requesting the booking. Must not be null. if null, the method has no effect.
     * @param  travelPackage The travel package to be booked. Must not be null. if null, the method has no effect.
     *
     * @throws Exception if there is no capacity available on the travel package.
     */
    void bookTravelPackage(Passenger passenger, TravelPackage travelPackage) throws Exception;

    /**
     * Books the requested activity for the passenger.
     *
     * @Param passenger The Passenger requesting the booking. Must not be null. if null, the method has no effect.
     * @Param activity The activity to be booked. Must not be null. if null, the method has no effect.
     *
     * @throws Exception if passenger doesn't have sufficient balance to book the ticket or if
     * there is no capacity available on the activity.
     * */
    void bookActivity(Passenger passenger, Activity activity) throws Exception;

    /**
     * Prints list of destinations for the given travel package
     *
     * @Param travelPackage The travel package from which destinations will be fetched. Must not be null. if null, the method has no effect.
     * */
    void printItinerary(TravelPackage travelPackage);

    /**
     * Prints list of passengers for the given travel package
     *
     * @Param travelPackage The travel package from which passengers will be fetched. Must not be null. if null, the method has no effect.
     * */
    void printPassengerList(TravelPackage travelPackage);

    /**
     * Prints the passenger details along with the list of activities that the passenger has signed up for.
     *
     * @Param passenger The Passenger for whom the details will be printed. Must not be null. if null, the method has no effect.
     * */
    void printPassengerDetails(Passenger passenger);

    /**
     * Prints list of Activities with available spaces
     *
     * @Param travelPackage The travel package from which activities with available spaces will be fetched. Must not be null. if null, the method has no effect.
     * */
    void printAvailableActivities(TravelPackage travelPackage);
}
