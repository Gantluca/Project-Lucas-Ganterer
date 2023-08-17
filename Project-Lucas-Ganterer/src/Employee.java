public class Employee extends Person {
    private String role;
    private float salary;
    public Employee(String name, String phoneNumber, String email, String role, float salary) {
        super(name, phoneNumber, email);
        this.role = role;
        this.salary = salary;
    }
    public String getRole() {
        return role;
    }
    public float getSalary(){
        return salary;
    }
    public void setRole(String role){
        this.role = role;
    }
    public void setSalary(float salary){
        if(salary <= 50000){
            this.salary = salary;
        }else{
            System.out.println("Too high");
            System.exit(0);
        }
    }
}