//Husen Abugosh (حسين ابوغوش) - 1210338 - lab section: 6
package com.example.proj_ii_1210338_s6;

public class Seated extends PizzaOrder {


    //attributes:
    private double serviceCharge;
    private int numberOfPeople;


    //constructors:
    public Seated(String customerName, int pizzaSize, int numberOfToppings, double toppingPrice, double serviceCharge,
            int numberOfPeople) {
        super(customerName, pizzaSize, numberOfToppings, toppingPrice);
        this.serviceCharge = serviceCharge;
        this.numberOfPeople = numberOfPeople;
    }

    public Seated(){
    }


    // Setters&Getters:

    public double getServiceCharge() {
        return serviceCharge;
    }
    public void setServiceCharge(double serviceCharge) {
        this.serviceCharge = serviceCharge;
    }

    public int getNumberOfPeople() {
        return numberOfPeople;
    }
    public void setNumberOfPeople(int numberOfPeople) {
        this.numberOfPeople = numberOfPeople;
    }



    // overRide Methods:

    @Override
    public String toString() {
    return super.toString() +
    "\nService Charge=" + serviceCharge +
    "\nNumber Of People=" + numberOfPeople ;
    }



    @Override
    public double calculateOrderPrice() {
        return super.calculateOrderPrice() + (getServiceCharge() * getNumberOfPeople());
    }
}
