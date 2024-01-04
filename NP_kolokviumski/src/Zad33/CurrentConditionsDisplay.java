package Zad33;

public class CurrentConditionsDisplay implements Updatable, Displayable{
    float temperature;
    float humidity;
    Subject weatherStation;
    public CurrentConditionsDisplay(Subject weatherStation) {
        this.weatherStation = weatherStation;
        this.weatherStation.register(this);
    }

    @Override
    public void display() {
        System.out.println("Temperature: " + temperature + "F");
        System.out.println("Humidity: " + humidity + "%");
    }

    @Override
    public void update(float temp, float humidity, float pressure) {
        this.temperature = temp;
        this.humidity = humidity;
        display();
    }
}
