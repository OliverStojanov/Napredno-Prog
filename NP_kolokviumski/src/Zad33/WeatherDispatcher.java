package Zad33;

import java.util.HashSet;
import java.util.Set;

public  class WeatherDispatcher implements Subject{
    float temperature;
    float humidity;
    float pressure;
    Set<Updatable> updatables;

    public WeatherDispatcher() {
        updatables = new HashSet<>();
    }

    public void setMeasurements(float temperature, float humidity, float pressure) {
        this.temperature = temperature;
        this.humidity = humidity;
        this.pressure = pressure;
        notifyUpdatable();
    }

    @Override
    public void register(Updatable o) {
        updatables.add(o);
    }

    @Override
    public void remove(Updatable o) {
        updatables.remove(o);
    }

    @Override
    public void notifyUpdatable() {
        for(Updatable updatable : updatables){
            updatable.update(temperature, humidity, pressure);
        }
    }
}
