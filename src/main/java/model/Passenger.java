package model;

import java.util.ArrayList;
import java.util.List;

public abstract class Passenger {

    public Passenger(String name, Integer number) {
        this.name = name;
        this.number = number;
        this.signedActivityList = new ArrayList<>();
    }

    public String name;
    public Integer number;
    public List<Activity> signedActivityList;

    public abstract double getAmountPaid(Activity activity);

    public abstract boolean canBuy(Activity activity);

    public abstract void buy(Activity activity);

    public abstract void printSignedActivityList();

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

    public void removeActivity(Activity activity) {
        signedActivityList.remove(activity);
    }
//
//    void printSignedActivityList() {
//        System.out.println("Passenger name : "+getName());
//        if(!getSignedActivityList().isEmpty()) {
//            System.out.println("List of activities passenger signed uo for :" + balance);
//            for (Activity activity : getSignedActivityList()) {
//                System.out.println("Activity name : " + activity.getName());
//                System.out.println("Destination : " + activity.getDestination().getName());
//                System.out.println("Price paid : " + getAmountPaid(activity));
//            }
//        } else{
//            System.out.println("List of activities passenger signed uo for :" + balance);
//        }
//    }
}
