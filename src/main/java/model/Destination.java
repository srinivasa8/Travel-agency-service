package model;

import java.util.ArrayList;
import java.util.List;

public class Destination {

    private String name;

    public Destination(String name) {
        this.name = name;
        this.activityList = new ArrayList<>();
    }

    private List<Activity> activityList;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Activity> getActivityList() {
        return activityList;
    }

    public void setActivityList(List<Activity> activityList) {
        this.activityList = activityList;
    }

    public void addActivity(Activity activity){
        activityList.add(activity);
    }

    public void removeActivity(Activity activity){
        activityList.remove(activity);
    }

}
