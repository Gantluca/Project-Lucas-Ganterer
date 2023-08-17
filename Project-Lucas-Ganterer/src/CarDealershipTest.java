import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
public class CarDealershipTest {
    @Test
    void testEmployeeCreation(){
        Employee employee = new Employee("John Doe", "555-1234", "john@example.com", "Salesperson", 5000);
        assertEquals("John Doe", employee.getName());
        assertEquals("Salesperson", employee.getRole());
        assertEquals(5000, employee.getSalary());
        assertEquals("555-1234", employee.getPhoneNumber());
        assertEquals("john@example.com", employee.getEmail());
    }
    @Test
    void testCarAvailability(){
        Car car = new Car("Toyota", "Camry", 2004, 25000, true);
        assertTrue(car.isAvailable());
        car.setAvailability(false);
        assertFalse(car.isAvailable());
    }
    @Test
    void testCustomerPaymentInsufficientFunds() {
        Customer customer = new Customer("Alice Smith", "777-9876", "alice@example.com", "SUV", 20000);
        Car car = new Car("Toyota", "Rav4", 2023, 30000, true);
        customer.pay(car);

        assertEquals(0, customer.getMoney());
        assertEquals(20000, customer.getBill());
    }
    @Test
    public void testCustomerPay() {
        Customer customer = new Customer("John Doe", "123-456-7890", "john@example.com", "SUV", 25000);
        Car car = new Car("Toyota", "Rav4", 2023, 30000, true);
        customer.pay(car);
        assertEquals(5000, customer.getMoney(), 0.01);
    }
    @Test
    public void testCarAvailabilityAfterPurchase() {
        Car car = new Car("Honda", "Civic", 2023, 20000, true);
        Customer customer = new Customer("Jane Smith", "987-654-3210", "jane@example.com", "Compact",
                22000);
        customer.pay(car);
        assertFalse(car.isAvailable());
    }
    @Test
    public void testAddCustomerToDealership() {
        CarDealership dealership = new CarDealership("Dream Cars", "123 Main Street");
        Customer customer = new Customer("Alice Johnson", "555-123-4567", "alice@example.com", "Convertible",
                50000);
        dealership.getCustomers().add(customer);
        assertTrue(dealership.getCustomers().contains(customer));
    }
}