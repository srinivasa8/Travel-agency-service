package model;

import java.util.List;

public class PremiumPassenger extends Passenger{

    public PremiumPassenger(String name, Integer number) {
        super(name, number);
    }

    @Override
    public double getAmountPaid(Activity activity) {
        return 0;
    }

    @Override
    public boolean canBuy(Activity activity) {
        return true;
    }

    @Override
    public void buy(Activity activity) {
        signedActivityList.add(activity);
    }

    @Override
    public void printSignedActivityList() {
        System.out.println("Passenger name : " + getName());
        if(!getSignedActivityList().isEmpty()) {
            System.out.println("List of activities passenger has signed up for :");
            for (Activity activity : getSignedActivityList()) {
                System.out.println("Activity name : " + activity.getName());
                System.out.println("Destination : " + activity.getDestination().getName());
                System.out.println("Price paid : " + getAmountPaid(activity));
            }
        } else{
            System.out.println("Passenger not signed up for any activities.");
        }
    }
}
