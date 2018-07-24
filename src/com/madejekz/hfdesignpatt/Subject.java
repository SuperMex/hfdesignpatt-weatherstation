package com.madejekz.hfdesignpatt;

/**
 * Created by madejekz on 7/23/2018.
 */
public interface Subject {
    public void registerObserver(Observer o);
    public void removeObserver(Observer o);
    public void notifyObservers();
}
