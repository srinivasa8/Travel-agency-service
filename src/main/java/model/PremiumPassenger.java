package model;

public class PremiumPassenger extends Passenger{
    @Override
    int calculateAmount(Activity activity) {
        return 0;
    }

    @Override
    boolean canBuy(Activity activity) {
        return true;
    }

    @Override
    void buy(Activity activity) {
        //not applicable
    }
}
