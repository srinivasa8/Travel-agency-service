package repositories;

import model.Destination;
import model.Passenger;
import model.TravelPackage;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TravelPackageRepository {

    /**
     * Using HashMap as an in memory db to store the travel package details.
     */
    private Map<String, TravelPackage> travelPackageMap;

    public TravelPackageRepository() {
        this.travelPackageMap = new HashMap<>();
    }

    /**
     * Creates the requested travel package
     *
     * @param travelPackage travelPackage can't be duplicate, If already present method throws exception.
     * @return String value (travel package name) uniquely to identify the travel package.
     * @throws Exception
     */
    public void createTravelPackage(TravelPackage travelPackage) throws Exception {
        if (travelPackageMap.containsKey(travelPackage.getName())) {
            throw new Exception("Travel package already present");
        }
        travelPackageMap.put(travelPackage.getName(), travelPackage);
    }

    /**
     * Updates the requested travel package
     *
     * @param travelPackage travelPackage can't be null, If null method throws exception
     * @throws Exception
     */
    public void updateTravelPackage(TravelPackage travelPackage) throws Exception {
        if (travelPackage == null) throw new Exception("Travel package can't be null");
        travelPackageMap.put(travelPackage.getName(), travelPackage);
    }


    /**
     * Updates the requested travel package
     *
     * @param travelPackageName If travel package not present with the given name,method throws exception
     * @throws Exception
     */
    public TravelPackage getTravelPackageByName(String travelPackageName) throws Exception {
        if (!travelPackageMap.containsKey(travelPackageName))
            throw new Exception("Travel package with given name does not exist!");
        return travelPackageMap.get(travelPackageName);
    }

    /**
     * Adds passenger to requested TravelPackage
     *
     * @param passenger         Passenger needs to be added
     * @param travelPackageName If travel package not present with the given name.
     * @throws Exception
     */
    public void addPassengerToTravelPackage(Passenger passenger, String travelPackageName) throws Exception {
        if (!travelPackageMap.containsKey(travelPackageName))
            throw new Exception("Travel package with given name does not exist!");
        travelPackageMap.get(travelPackageName).addPassenger(passenger);
    }

    /**
     * Adds destination to the given Travel package
     *
     * @param destination       destination needs to be added
     * @param travelPackageName travelPackageName to which destination need to be added.
     * @throws Exception If travel package not present with the given name.
     */
    public void addDestinationToTravelPackage(Destination destination, String travelPackageName) throws Exception {
        if (!travelPackageMap.containsKey(travelPackageName))
            throw new Exception("Travel package with given name does not exist!");
        travelPackageMap.get(travelPackageName).getDestinationList().add(destination);
    }

    /**
     * Get destination list for the given travel package name
     *
     * @param travelPackageName travelPackageName from which destination need to be fetched.
     * @return List<Destination> List of destination will be returned for the given travel package name.
     * @throws Exception If travel package not present with the given name.
     */
    public List<Destination> getDestinationByTravelPackageName(String travelPackageName) throws Exception {
        if (!travelPackageMap.containsKey(travelPackageName))
            throw new Exception("Travel package with given name does not exist!");
        return travelPackageMap.get(travelPackageName).getDestinationList();
    }

}
