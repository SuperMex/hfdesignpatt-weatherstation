package com.madejekz.hfdesignpatt;

import java.util.Observable;
import java.util.Observer;

/**
 * Created by madejekz on 7/23/2018.
 */
public class ForecastDisplay implements Observer, DisplayElement {
    private float currentPressure = 29.92f;
    private float lastPressure;
    private Observable observable;

    public ForecastDisplay(Observable observable) {
        this.observable = observable;
        observable.addObserver(this);
    }

    @Override
    public void update(Observable o, Object arg) {
        if (o instanceof WeatherData) {
            WeatherData weatherData = (WeatherData) o;
            this.lastPressure = currentPressure;
            this.currentPressure = weatherData.getPressure();
            display();
        }
    }

    @Override
    public void display() {
        System.out.println("Forecast: ");
        if (currentPressure > lastPressure)
            System.out.println("Improving weather on the way!");
        else if (currentPressure == lastPressure)
            System.out.println("More of the same");
        else
            System.out.println("Watch out for cooler, rainy weather");
    }
}
