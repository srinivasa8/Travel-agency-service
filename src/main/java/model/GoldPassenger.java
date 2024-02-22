package model;

import java.util.List;

public class GoldPassenger extends Passenger {

    private double balance;

    public GoldPassenger(String name, Integer number, double balance) {
        super(name, number);
        this.balance = balance;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    @Override
    public double getAmountPaid(Activity activity) {
        //10% discount is provided
        return (int) (0.9 * activity.getCost());
    }

    @Override
    public boolean canBuy(Activity activity) {
        double cost = 0.9 * activity.getCost();
        return cost <= balance;
    }

    @Override
    public void buy(Activity activity) {
        int cost = (int) (0.9 * activity.getCost());
        balance -= cost;
        signedActivityList.add(activity);
    }

    @Override
    public void printSignedActivityList() {
        System.out.println("Passenger name : " + getName());
        System.out.println("Balance : " + balance);
        if (!getSignedActivityList().isEmpty()) {
            System.out.println("List of activities passenger has signed up for :");
            for (Activity activity : getSignedActivityList()) {
                System.out.println("Activity name : " + activity.getName());
                System.out.println("Destination : " + activity.getDestination().getName());
                System.out.println("Price paid : " + getAmountPaid(activity));
            }
        } else {
            System.out.println("Passenger not signed up for any activities.");
        }
    }

}