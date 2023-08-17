public class Car {
    String make;
    String model;
    int year;
    float price;
    boolean availability;
    public Car(String make, String model, int year, float price, boolean availability){
        this.make = make;
        this.model = model;
        this.year = year;
        this.price = price;
        this.availability = availability;
    }
    public float getPrice(){
        return price;
    }
    public String getMake(){
        return make;
    }
    public String getModel(){
        return model;
    }
    public int getYear(){
        return year;
    }
    public boolean getAvailability(){
        return availability;
    }
    public boolean isAvailable(){
        return availability;

    }
    public void setAvailability(boolean availability){
        this.availability = availability;
    }
}