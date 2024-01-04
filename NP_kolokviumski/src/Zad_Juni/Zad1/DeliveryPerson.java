package Zad_Juni.Zad1;

public class DeliveryPerson {
    String id;
    String name;
    Location currentLocation;
    int numOfDeliveries;
    float earnings;
    public DeliveryPerson(String id, String name, Location currentLocation) {
        this.id = id;
        this.name = name;
        this.currentLocation = currentLocation;
        numOfDeliveries = 0;
        earnings = 0;
    }

    public void setCurrentLocation(Location currentLocation) {
        this.currentLocation = currentLocation;
    }

    public String getId() {
        return id;
    }

    public void increaseNumOfDeliveries() {
        this.numOfDeliveries += 1;
    }

    public int getNumOfDeliveries() {
        return numOfDeliveries;
    }

    public float getEarnings() {
        return earnings;
    }

    public void setEarnings(float earnings) {
        this.earnings += earnings;
        increaseNumOfDeliveries();
    }

    @Override
    public String toString() {
        return String.format("ID: %s Name: %s Total deliveries: %d Total delivery fee: %.2f Average delivery fee: %.2f",
                id,name,numOfDeliveries,earnings,numOfDeliveries==0?0:earnings/numOfDeliveries);
    }
}
