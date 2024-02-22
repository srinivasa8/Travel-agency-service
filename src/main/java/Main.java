import model.Activity;
import model.Destination;
import model.GoldPassenger;
import model.Passenger;
import model.PremiumPassenger;
import model.StandardPassenger;
import model.TravelPackage;

public class Main {

//    //craete all models
//    initialize travel package
//    and print all functions as requested

    public static void main(String[] args) {

        Passenger p1 = new StandardPassenger("p1",1,100);
        Passenger p2 = new GoldPassenger("p2",2,100);
        Passenger p3 = new PremiumPassenger("p3",3);

        Destination destination1 = new Destination("destination1");
        Destination destination2 = new Destination("destination2");

        Activity activity1 = new Activity("Water ride","You can play on a boat ride!",25,2,destination1);
        Activity activity2 = new Activity("Bungy jump","You can enjoy with bungy jump!",25,2,destination1);

        destination1.addActivity(activity1);
        destination1.addActivity(activity2);

        TravelPackage travelPackage = new TravelPackage("Goa trip",3);
        travelPackage.addDestination(destination1);
        travelPackage.addDestination(destination2);
        travelPackage.addPassenger(p1);
        travelPackage.addPassenger(p2);
        travelPackage.addPassenger(p2);

        activity1.addPassenger(p1);
        p1.buy(activity1);
        p1.buy(activity2);

        activity1.addPassenger(p2);

        p2.buy(activity1);
        p2.buy(activity2);

        activity2.addPassenger(p3);
        p3.buy(activity2);

        System.out.println("------------------------------------------------------");
        travelPackage.printItinerary();
        System.out.println("------------------------------------------------------");
        travelPackage.printPassengerList();
        System.out.println("------------------------------------------------------");
        travelPackage.printAvailableActivities();
        System.out.println("------------------------------------------------------");
        p1.printSignedActivityList();
    }
}
