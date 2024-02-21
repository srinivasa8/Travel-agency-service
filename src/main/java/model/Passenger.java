package model;

public abstract class Passenger {
    private String name;
    private Integer no;

    abstract int calculateAmount(Activity activity);

    abstract boolean canBuy(Activity activity);

    abstract void buy(Activity activity);

}
