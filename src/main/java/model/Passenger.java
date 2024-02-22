package model;

import java.util.ArrayList;
import java.util.List;

public abstract class Passenger {

    public String name;
    public Integer number;
    public List<Activity> signedActivityList;

    public Passenger(String name, Integer number) {
        this.name = name;
        this.number = number;
        this.signedActivityList = new ArrayList<>();
    }

    public abstract double getAmount(Activity activity);

    public abstract boolean canBuy(Activity activity);

    public abstract void buy(Activity activity);

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public List<Activity> getSignedActivityList() {
        return signedActivityList;
    }

    public void setSignedActivityList(List<Activity> signedActivityList) {
        this.signedActivityList = signedActivityList;
    }

    public void addActivity(Activity activity) {
        buy(activity);
        signedActivityList.add(activity);
    }

}
