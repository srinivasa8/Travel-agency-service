package repositories;

import model.Destination;
import model.Passenger;
import model.TravelPackage;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TravelPackageRepository {

    /**
     * Using HashMap as In memory db to store the the travel package details.
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
        if (!travelPackageMap.containsKey(travelPackageName)) throw new Exception("Travel package with given name does not exist!");
        return travelPackageMap.get(travelPackageName);
    }

    /**
     * Adds passenger to requested TravelPackage
     * @param passenger Passenger needs to be added, It can't be null if null method throws exception.
     * @param travelPackageName TravelPackageName to which passenger need to be added. It can't be null or empty, otherwise method throws error
     *                          If travel package not present with the given name,method throws exception
     * @throws Exception
     */
    public void addPassengerToTravelPackage(Passenger passenger, String travelPackageName) throws Exception {
        if (!travelPackageMap.containsKey(travelPackageName)) throw new Exception("Travel package with given name does not exist!");
        travelPackageMap.get(travelPackageName).addPassenger(passenger);
    }

    /**
     * Adds destination to the given Travel package
     *
     * @param destination destination needs to be added
     * @param travelPackageName
     * @throws Exception
     */
    public void addDestinationToTravelPackage(Destination destination, String travelPackageName) throws Exception {
        if (!travelPackageMap.containsKey(travelPackageName)) throw new Exception("Travel package with given name does not exist!");
        travelPackageMap.get(travelPackageName).getDestinationList().add(destination);
    }

    public List<Destination> getDestinationByTravelPackageName(String travelPackageName) throws Exception {
        if (!travelPackageMap.containsKey(travelPackageName))
            throw new Exception("Travel package with given name does not exist!");
        return travelPackageMap.get(travelPackageName).getDestinationList();
    }

}
