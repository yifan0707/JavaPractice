package designpattern.observer;

import java.util.HashMap;

public interface Observer {
    public void update(HashMap<MerchandiseName,Integer> map);
}
