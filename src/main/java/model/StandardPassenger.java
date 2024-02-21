package model;

public class StandardPassenger extends Passenger{

    private Integer balance;

    @Override
    int calculateAmount(Activity activity){
        return activity.getCost();
    }

    @Override
    boolean canBuy(Activity activity){
        return activity.getCost() <=balance;
    }

    @Override
    void buy(Activity activity) {
        balance-= activity.getCost();
    }

}
