package model;

import java.util.List;

public class PremiumPassenger extends Passenger{

    public PremiumPassenger(String name, Integer number) {
        super(name, number);
    }

    @Override
    public double getAmount(Activity activity) {
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

}
