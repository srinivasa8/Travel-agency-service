package model;

import java.util.List;

public class GoldPassenger extends Passenger {

    private double balance;;

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
    public double getAmount(Activity activity) {
        //10% discount is provided
        return (int) (0.9 * activity.getCost());
    }

    @Override
    public boolean canBuy(Activity activity) {
        //10% discount is provided, i.e 100-10=90.
        double cost = 0.9 * activity.getCost();
        return cost <= balance;
    }

    @Override
    public void buy(Activity activity) {
        int cost = (int) (0.9 * activity.getCost());
        balance -= cost;
        signedActivityList.add(activity);
    }

}