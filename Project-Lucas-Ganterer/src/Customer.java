public class Customer extends Person{
    String preferredCarSpecs;
    float money;
    float bill;
    public Customer(String name, String phoneNumber, String email, String preferredCarSpecs, float money){
        super(name, phoneNumber, email);
        this.preferredCarSpecs = preferredCarSpecs;
        this.money = Math.max(0, money);
    }
    public String getPreferredCarSpecs(){
        return preferredCarSpecs;
    }
    public float getMoney(){
        return money;
    }
    public float getBill(){
        return bill;
    }

    public void pay (Car car){
        bill = car.getPrice();
        if(this.money < this.bill){
            double debt = this.money - this.bill;
            this.money = 0;
            System.out.println("Customer's debt is: " + debt);
        }else{
            this.money -= this.bill;
            System.out.println("Customer still has " + money);
        }
    }
}