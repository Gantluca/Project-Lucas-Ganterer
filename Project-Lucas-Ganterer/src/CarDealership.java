import java.util.ArrayList;
import java.util.List;
public class CarDealership {
    private String name;
    private String location;
    private List<Employee> employees = new ArrayList<>();

    private List<Car> cars = new ArrayList<>();
    private List<Supplier> supplier = new ArrayList<>();
    private List<Customer> customers = new ArrayList<>();
    public CarDealership(String name, String location) {
        this.name = name;
        this.location = location;
    }
    public Customer findCustomerByName(String name){
        for (Customer customer : customers){
            if (customer.getName().equalsIgnoreCase(name)){
                return customer;
            }
        }
        return null;
    }
    public Car findCarByMake(String make){
        for (Car car : cars){
            if(car.getMake().equalsIgnoreCase(make)){
                return car;
            }
        }
        return null;
    }
    public List<Employee> getEmployees() {
        return employees;
    }
    public List<Car> getCars() {
        return cars;
    }
    public List<Customer> getCustomers() {
        return customers;
    }
    public List<Supplier> getSupplier() {
        return supplier;
    }
}