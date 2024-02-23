package service;

import model.Activity;
import model.Destination;
import model.Passenger;
import model.TravelPackage;

public interface TravelAgencyService {


    /**
     * Creates the requested travel package
     *
     * @param travelPackage The travelPackage to be created. Must not be null. Otherwise, method throws exception.
     *
     * @throws Exception
     */
    void createTravelPackage(TravelPackage travelPackage) throws Exception;


    /**
     * Updates the requested travel package
     *
     * @param travelPackage The travelPackage to be updated. Must not be null. Otherwise, method throws exception.
     *
     * @throws Exception
     */
    void updateTravelPackage(TravelPackage travelPackage) throws Exception;

    /**
     * Adds the requested destination to the travel package.
     *
     * @param destination The destination to be added. Must not be null. Otherwise, method throws exception.
     * @param travelPackageName The travel package name to which the destination will be added. Must not be null.  Otherwise, method throws exception.
     *
     * @throws Exception if inputs are invalid
     */
    void addDestinationToTravelPackage(Destination destination, String travelPackageName) throws Exception;

    /**
     * Books the requested travelPackage for the passenger.
     *
     * @Param passenger The Passenger requesting the booking. Must not be null. if null, the method has no effect.
     * @param  travelPackageName The travel package name to be booked. Must not be empty or null. Otherwise, the method throws exception.
     *
     * @throws Exception if inputs are invalid or if there is no capacity available on the travel package
     */
    void bookTravelPackage(Passenger passenger, String travelPackageName) throws Exception;

    /**
     * Books the requested activity for the passenger.
     *
     * @Param passenger The Passenger requesting the booking. Must not be null. Otherwise, the method throws exception.
     * @Param activity The activity to be booked. Must not be null. Otherwise, the method throws exception.
     *
     * @throws Exception If inputs are invalid or passenger doesn't have sufficient balance to book the ticket or if
     *                   there is no capacity available on the activity.
     * */
    void bookActivity(Passenger passenger, Activity activity) throws Exception;

    /**
     * Prints list of destinations for the given travel package name
     *
     * @Param travelPackage The travel package from which destinations will be fetched. Must not be null. Otherwise, the method throws exception.
     *
     * @throws Exception If inputs are not valid
     * */
    void printItinerary(String travelPackageName) throws Exception;

    /**
     * Prints list of passengers for the given travel package name
     *
     * @Param travelPackageName The travel package name from which passengers will be fetched. Must not be null.  Otherwise, the method throws exception.
     *
     * @throws Exception if inputs are invalid
     * */
    void printPassengerList(String travelPackageName) throws Exception;

    /**
     * Prints the passenger details along with the list of activities that the passenger has signed up for.
     *
     * @Param passenger The Passenger for whom the details will be printed. Must not be null. if null, the method has no effect.
     * */
    void printPassengerDetails(Passenger passenger);

    /**
     * Prints list of Activities with available spaces
     *
     * @Param travelPackageName The travel package from which activities with available spaces will be fetched. Must not be null. Otherwise, the method throws exception..
     * @throws Exception
     * */
    void printAvailableActivities(String travelPackageName) throws Exception;
}
