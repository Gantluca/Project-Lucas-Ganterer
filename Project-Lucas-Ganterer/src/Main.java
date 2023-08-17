import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CarDealership dealership = new CarDealership("Dream Cars", "123 Main Street");
        Supplier predefinedSupplier = new Supplier("Original Supplier", "123 Supplier Street",
                "supplier@example.com");
        boolean exit = false;
        while (!exit) {
            System.out.println("Select an option:");
            System.out.println("1. Add Customer");
            System.out.println("2. Add Employee");
            System.out.println("3. Add Supplier");
            System.out.println("4. Add Car");
            System.out.println("5. Customer Buy Car");
            System.out.println("6. Exit");
            int option = scanner.nextInt();
            scanner.nextLine();
            switch (option) {
                case 1:
                    addCustomer(dealership, scanner);
                    break;
                case 2:
                    addEmployee(dealership, scanner);
                    break;
                case 3:
                    addSupplier(dealership, scanner);
                    break;
                case 4:
                    addCar(dealership, predefinedSupplier, scanner);
                    break;
                case 5:
                    simulateBuyCar(dealership, scanner);
                    break;
                case 6:
                    System.out.println("Exiting program");
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid option: Please select again");
                    break;
            }
        }
    }

    private static void addCustomer(CarDealership dealership, Scanner scanner) {
        String cust1, cust2, cust3, cust4;
        float cust5;
        System.out.println("Enter Customer name: ");
        cust1 = scanner.nextLine();
        System.out.println("Enter Customer Phone number: ");
        cust2 = scanner.nextLine();
        System.out.println("Enter Customer Email: ");
        cust3 = scanner.nextLine();
        System.out.println("Enter Customer Preferred Car Specs: ");
        cust4 = scanner.nextLine();
        System.out.println("Enter Customer Money: ");
        cust5 = scanner.nextFloat();
        scanner.nextLine();
        Customer customer = new Customer(cust1, cust2, cust3, cust4, cust5);
        dealership.getCustomers().add(customer);
        System.out.println("Customer Added:");

        System.out.println("Name: " + customer.getName());
        System.out.println("Phone Number: " + customer.getPhoneNumber());
        System.out.println("Email: " + customer.getEmail());
        System.out.println("Preferred Car Specs: " + customer.getPreferredCarSpecs());
        System.out.println("Money: " + customer.getMoney());
        System.out.println();
    }

    private static void addEmployee(CarDealership dealership, Scanner scanner) {
        String emp1, emp2, emp3, emp4;
        float emp5;
        System.out.println("Enter Employee name: ");
        emp1 = scanner.nextLine();
        System.out.println("Enter Employee Phone number: ");
        emp2 = scanner.nextLine();
        System.out.println("Enter Employee Email: ");
        emp3 = scanner.nextLine();
        System.out.println("Enter Employee Role: ");
        emp4 = scanner.nextLine();
        System.out.println("Enter Employee Salary: ");
        emp5 = scanner.nextFloat();
        scanner.nextLine();
        Employee employee = new Employee(emp1, emp2, emp3, emp4, emp5);
        dealership.getEmployees().add(employee);
        System.out.println("Employee Added:");
        System.out.println("Name: " + employee.getName());
        System.out.println("Phone Number: " + employee.getPhoneNumber());
        System.out.println("Email: " + employee.getEmail());
        System.out.println("Role: " + employee.getRole());
        System.out.println("Salary: " + employee.getSalary());
        System.out.println();
    }

    private static void addSupplier(CarDealership dealership, Scanner scanner) {
        String sup1, sup2, sup3;
        System.out.println("Enter Supplier name: ");
        sup1 = scanner.nextLine();
        System.out.println("Enter Supplier Phone number: ");
        sup2 = scanner.nextLine();
        System.out.println("Enter Supplier Email: ");
        sup3 = scanner.nextLine();
        scanner.nextLine();
        Supplier supplier = new Supplier(sup1, sup2, sup3);
        dealership.getSupplier().add(supplier);
        System.out.println("Supplier Added:");
        System.out.println("Name: " + supplier.getName());
        System.out.println("Phone Number: " + supplier.getPhoneNumber());
        System.out.println("Email: " + supplier.getEmail());
        System.out.println();
    }

    private static void addCar(CarDealership dealership, Supplier supplier, Scanner scanner) {
        String car1, car2;
        int car3;
        float car4;
        boolean car5;
        System.out.println("Enter Car make: ");
        car1 = scanner.nextLine();
        System.out.println("Enter Car model: ");
        car2 = scanner.nextLine();
        System.out.println("Enter Car year: ");
        car3 = scanner.nextInt();
        System.out.println("Enter Car Price: ");
        car4 = scanner.nextInt();
        System.out.println("Enter Car availability: ");
        car5 = scanner.nextBoolean();
        scanner.nextLine();

        Car car = new Car(car1, car2, car3, car4, car5);
        dealership.getCars().add(car);
        if (!supplier.getSuppliedCars().isEmpty()) {
            Car suppliedCar = supplier.getSuppliedCars().get(0);
            dealership.getCars().add(suppliedCar);
            supplier.retrieveCar(suppliedCar);
            System.out.println("Car supplied by supplier and added to inventory");
        } else {
            System.out.println("No cars supplied by the supplier");
        }
        if (!supplier.getSuppliedCars().isEmpty()) {
            Car suppliedCar = supplier.getSuppliedCars().get(0);
            dealership.getCars().add(suppliedCar);
            supplier.retrieveCar(suppliedCar);
            System.out.println("Car supplied by supplier and added to inventory");
        } else {
            System.out.println("No cars supplied by the supplier");
        }
        System.out.println("Car Added:");
        System.out.println("Make: " + car.getMake());
        System.out.println("Model " + car.getModel());
        System.out.println("Year: " + car.getYear());
        System.out.println("Price: " + car.getYear());
        System.out.println("Availability: " + car.getAvailability());
        System.out.println();
    }

    private static void simulateBuyCar(CarDealership dealership, Scanner scanner) {
        System.out.println("Enter customer's name: ");
        String customerName = scanner.nextLine();
        System.out.println("Enter car's make: ");
        String carMake = scanner.nextLine();

        Customer customer = dealership.findCustomerByName(customerName);
        Car car = dealership.findCarByMake(carMake);
        if (customer != null && car != null) {
            if (car.isAvailable()) {
                customer.pay(car);
                car.setAvailability(false);
                System.out.println("Car purchased successfully!");
            } else {
                System.out.println("Car is not available for purchase.");
            }
        } else {
            System.out.println("Customer or car not found.");
        }
    }
}