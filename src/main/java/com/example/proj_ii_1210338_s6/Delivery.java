//Husen Abugosh (حسين ابوغوش) - 1210338 - lab section: 6
package com.example.proj_ii_1210338_s6;


public class Delivery extends PizzaOrder {

    // atributes:
    private double tripRate;
    private int zone; // (should be 1-4)

    // constructors:
    public Delivery(String customerName, int pizzaSize, int numberOfToppings, double toppingPrice,double tripRate, int zone) {
        super(customerName, pizzaSize, numberOfToppings, toppingPrice);
        this.tripRate = tripRate;
        this.zone = zone;
    }

    // setters&Getters:
    public double getTripRate() {
        return tripRate;
    }
    public void setTripRate(double tripRate) {
        this.tripRate = tripRate;
    }

    public int getZone() {
        return zone;
    }
    public void setZone(int zone) {
        this.zone = zone;
    }


     @Override
    public String toString() {
        return super.toString() +
        "\nTrip Rate = " + (int)tripRate +
        "\nZone = " + zone;
    }



    //Methods:

   // calculateOrderPrice Method: which calculates the price of the pizza order.
   @Override
   public double calculateOrderPrice() {

       double totalPrice = super.calculateOrderPrice();
       double finalPrice = (getTripRate()/100 * totalPrice * getZone()) + totalPrice;
       return finalPrice;
   }

}
