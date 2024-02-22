package model;

import java.util.List;

public class StandardPassenger extends Passenger{

    private double balance;

    public StandardPassenger(String name, Integer number, double balance) {
        super(name, number);
        this.balance=balance;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    @Override
    public double getAmountPaid(Activity activity){
        return activity.getCost();
    }

    @Override
    public boolean canBuy(Activity activity){
        return activity.getCost() <=balance;
    }

    @Override
    public void buy(Activity activity) {
        balance-= activity.getCost();
        signedActivityList.add(activity);
    }

    @Override
    public void printSignedActivityList() {
        System.out.println("Passenger name : " + getName());
        System.out.println("Balance : " + balance);
        System.out.println("siz : " + signedActivityList.size());
        if (!getSignedActivityList().isEmpty()) {
            System.out.println("List of activities passenger has signed up for :");
            for (Activity activity : signedActivityList) {
                System.out.println("Activity name : " + activity.getName());
                System.out.println("Destination : " + activity.getDestination().getName());
                System.out.println("Price paid : " + getAmountPaid(activity));
            }
        } else {
            System.out.println("Passenger not signed up for any activities.");
        }
    }

}
