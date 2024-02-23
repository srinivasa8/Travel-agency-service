import model.Activity;
import model.Destination;
import model.GoldPassenger;
import model.Passenger;
import model.PremiumPassenger;
import model.StandardPassenger;
import model.TravelPackage;
import service.Impl.TravelAgencyServiceImpl;
import service.TravelAgencyService;

public class Main {


    public static void main(String[] args) {
        try {

            TravelAgencyService travelAgencyService = new TravelAgencyServiceImpl();

            Passenger p1 = new StandardPassenger("p1", 1, 100);
            Passenger p2 = new GoldPassenger("p2", 2, 100);
            Passenger p3 = new PremiumPassenger("p3", 3);

            Destination destination1 = new Destination("destination1");
            Destination destination2 = new Destination("destination2");

            Activity activity1 = new Activity("Water ride", "You can play on a boat ride!", 25, 2, destination1);
            Activity activity2 = new Activity("Bungy jump", "You can enjoy with bungy jump!", 25, 2, destination1);

            destination1.addActivity(activity1);
            destination1.addActivity(activity2);

            String travelPackageName = "Goa trip";
            TravelPackage travelPackage = new TravelPackage("Goa trip", 3);
            travelAgencyService.createTravelPackage(travelPackage);

            travelAgencyService.addDestinationToTravelPackage(destination1, travelPackageName);
            travelAgencyService.addDestinationToTravelPackage(destination2, travelPackageName);

            travelAgencyService.bookTravelPackage(p1, travelPackageName);
            travelAgencyService.bookTravelPackage(p2, travelPackageName);
            travelAgencyService.bookTravelPackage(p3, travelPackageName);

            travelAgencyService.bookActivity(p1, activity1);
            travelAgencyService.bookActivity(p1, activity2);

            System.out.println("------------------------------------------------------");
            travelAgencyService.printItinerary(travelPackageName);

            System.out.println("------------------------------------------------------");
            travelAgencyService.printPassengerList(travelPackageName);

            System.out.println("------------------------------------------------------");
            travelAgencyService.printAvailableActivities(travelPackageName);

            System.out.println("------------------------------------------------------");
            travelAgencyService.printPassengerDetails(p1);
        }
        catch(Exception e){
            System.out.println("Exception occurred: " +e.getMessage());
        }
    }
}
