package model;



public class StandardPassenger extends Passenger {

    private double balance;

    public StandardPassenger(String name, Integer number, double balance) {
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
        return activity.getCost();
    }

    @Override
    public boolean canBuy(Activity activity) {
        return activity.getCost() <= balance;
    }

    @Override
    public void buy(Activity activity) {
        balance -= activity.getCost();
        signedActivityList.add(activity);
    }

}
