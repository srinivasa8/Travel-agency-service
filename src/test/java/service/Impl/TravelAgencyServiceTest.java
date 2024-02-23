package service.Impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import model.Activity;
import model.Destination;
import model.Passenger;
import model.PremiumPassenger;
import model.StandardPassenger;
import model.TravelPackage;
import org.junit.jupiter.api.Test;
import service.TravelAgencyService;

class TravelAgencyServiceTest {

    @Test
    void testBookActivityForPremiumPassenger() throws Exception {
        TravelAgencyService travelAgencyService = new TravelAgencyServiceImpl();
        Passenger passenger = new PremiumPassenger("p1", 1);
        Destination destination1 = new Destination("destination1");
        Activity activity = new Activity("Water ride", "You can play on a boat ride!", 25, 2, destination1);
        travelAgencyService.bookActivity(passenger, activity);
        assertEquals(1, activity.getPassengerList().size());
        assertEquals(1, passenger.getSignedActivityList().size());
    }

    @Test
    void testBookActivityForGoldPassenger() throws Exception {
        TravelAgencyService travelAgencyService = new TravelAgencyServiceImpl();
        Passenger passenger = new StandardPassenger("p1", 1, 100);
        Destination destination1 = new Destination("destination1");
        Activity activity = new Activity("Water ride", "You can play on a boat ride!", 25, 2, destination1);
        travelAgencyService.bookActivity(passenger, activity);
        assertEquals(1, activity.getPassengerList().size());
        assertEquals(1, passenger.getSignedActivityList().size());
    }

    @Test
    void testBookActivityForStandardPassenger() {
        TravelAgencyService travelAgencyService = new TravelAgencyServiceImpl();
        Passenger passenger = new StandardPassenger("p1", 1, 10);
        Destination destination1 = new Destination("destination1");
        Activity activity = new Activity("Water ride", "You can play on a boat ride!", 25, 2, destination1);
        assertThrows(Exception.class, () -> travelAgencyService.bookActivity(passenger, activity));
    }

    @Test
    void testBookActivityForForOutOfCapacity() {
        TravelAgencyService travelAgencyService = new TravelAgencyServiceImpl();
        Passenger p1 = new StandardPassenger("p1", 1, 10);
        Passenger p2 = new StandardPassenger("p1", 1, 10);
        Destination destination1 = new Destination("destination1");
        Activity activity = new Activity("Water ride", "You can play on a boat ride!", 25, 1, destination1);
        activity.addPassenger(p1);
        activity.addPassenger(p2);
        assertThrows(Exception.class, () -> travelAgencyService.bookActivity(p1, activity));
    }

    @Test
    void testBookTravelPackageTest() throws Exception {
        TravelAgencyService travelAgencyService = new TravelAgencyServiceImpl();
        Passenger p1 = new StandardPassenger("p1", 1, 10);
        Destination destination1 = new Destination("destination1");
        String travelPackageName = "Goa trip";
        TravelPackage travelPackage = new TravelPackage("Goa trip", 3);
        travelAgencyService.createTravelPackage(travelPackage);
        travelAgencyService.addDestinationToTravelPackage(destination1, travelPackageName);
        travelAgencyService.bookTravelPackage(p1, travelPackageName);
        assertEquals(1, travelPackage.getPassengerList().size());
    }

    @Test
    void testBookTravelPackageOutOfCapacity() throws Exception {
        TravelAgencyService travelAgencyService = new TravelAgencyServiceImpl();
        Passenger p1 = new StandardPassenger("p1", 1, 10);
        Passenger p2 = new StandardPassenger("p1", 1, 10);
        Destination destination1 = new Destination("destination1");
        String travelPackageName = "Goa trip";
        TravelPackage travelPackage = new TravelPackage("Goa trip", 1);
        travelAgencyService.createTravelPackage(travelPackage);
        travelAgencyService.addDestinationToTravelPackage(destination1, travelPackageName);
        travelAgencyService.bookTravelPackage(p1, travelPackageName);
        assertThrows(Exception.class, () -> travelAgencyService.bookTravelPackage(p2, travelPackageName));
    }

    @Test
    void testBookTravelPackageTravelPackageNameNotExist() throws Exception {
        TravelAgencyService travelAgencyService = new TravelAgencyServiceImpl();
        Passenger p1 = new StandardPassenger("p1", 1, 10);
        Destination destination1 = new Destination("destination1");
        String travelPackageName = "Goa trip";
        TravelPackage travelPackage = new TravelPackage("Goa trip", 1);
        travelAgencyService.createTravelPackage(travelPackage);
        travelAgencyService.addDestinationToTravelPackage(destination1, travelPackageName);
        assertThrows(Exception.class, () -> travelAgencyService.bookTravelPackage(p1, "North indian trip"));
    }


}