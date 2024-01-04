package Zad33;

public class ForecastDisplay implements Updatable, Displayable{
    float currPressure = 0.0f;
    float prevPressure;
    Subject weatherStation;
    public ForecastDisplay(Subject weatherStation) {
        this.weatherStation = weatherStation;
        this.weatherStation.register(this);
    }

    @Override
    public void display() {
        System.out.print("Forecast: ");
        if (currPressure > prevPressure) {
            System.out.println("Improving\n");
        } else if (currPressure == prevPressure) {
            System.out.println("Same\n");
        } else if (currPressure < prevPressure) {
            System.out.println("Cooler\n");
        }
    }

    @Override
    public void update(float temp, float humidity, float pressure) {
        prevPressure = currPressure;
        currPressure = pressure;
        display();
    }
}
