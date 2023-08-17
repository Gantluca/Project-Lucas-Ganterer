import java.util.ArrayList;
import java.util.List;
public class Supplier extends Person {
    public Supplier(String name, String phoneNumber, String email){
        super(name, phoneNumber, email);
    }
    private List<Car> suppliedCars = new ArrayList<>();
    public void retrieveCar(Car car){
        car.setAvailability(true);
        suppliedCars.remove(car);
    }
    public List<Car> getSuppliedCars(){
        return suppliedCars;
    }
}