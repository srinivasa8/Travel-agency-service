package model;

public class GoldPassenger extends Passenger {

    private int balance;

    @Override
    int calculateAmount(Activity activity) {
        //10% discount is provided
        return (int) (0.9 * activity.getCost());
    }

    @Override
    boolean canBuy(Activity activity) {
        int cost = (int) (0.9*activity.getCost());
        return cost<=balance;
    }

    @Override
    void buy(Activity activity) {
        int cost = (int) (0.9*activity.getCost());
        balance-=cost;
    }


}