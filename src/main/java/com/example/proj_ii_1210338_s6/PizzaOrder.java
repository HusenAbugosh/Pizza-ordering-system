package com.example.proj_ii_1210338_s6;//Husen Abugosh (حسين ابوغوش) - 1210338 - lab section: 6

import java.util.Date;

public class PizzaOrder implements Comparable<PizzaOrder>  {

    //atributes:
    private String customerName;
    private Date dateOrder;
    private int numberOfToppings;
    private double toppingPrice;
    private int pizzaSize;

    final static int SMALL = 1;
    final static int MEDIUM = 2;
    final static int LARGE = 3;



    //constructors:
    public PizzaOrder(String customerName, int pizzaSize, int numberOfToppings, double toppingPrice) {
        this.customerName = customerName;
        this.pizzaSize = pizzaSize;
        this.numberOfToppings = numberOfToppings;
        this.toppingPrice = toppingPrice;
        this.dateOrder = new Date();  
    }

    public PizzaOrder(){
        this.dateOrder = new Date(); 
    }


    //Setters&Getters:

    public String getCustomerName() {
        return customerName;
    }
    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public Date getDateOrder() {
        return dateOrder;
    }
    public void setDateOrder(Date dateOrder) {
        this.dateOrder = dateOrder;
    }


    public int getNumberOfToppings() {
        return numberOfToppings;
    }
    public void setNumberOfToppings(int numberOfToppings) {
        this.numberOfToppings = numberOfToppings;
    }


    public double getToppingPrice() {
        return toppingPrice;
    }
    public void setToppingPrice(double toppingPrice) {
        this.toppingPrice = toppingPrice;
    }

    public int getPizzaSize() {
        return pizzaSize;
    }
    public void setPizzaSize(int pizzaSize) {
        this.pizzaSize = pizzaSize;
    }


    public static int getSmall() {
        return SMALL;
    }
    public static int getMedium() {
        return MEDIUM;
    }
    public static int getLarge() {
        return LARGE;
    }

    //ToString:
    @Override
    public String toString() {

        // this IF used to print S,M,L instead of using the numbers 1,2,3
        String choice = "";
        if(pizzaSize  == 1){
            choice = "small";
        }else if(pizzaSize  == 2){
            choice = "medium";
        }else if(pizzaSize  == 3){
            choice = "large";
        }

        return "Customer Name = " + customerName + 
        "\nDate Orderd = " + dateOrder + 
        "\nPizza Size = " + choice +
        "\nNumber of Toppings = " + numberOfToppings + 
        "\nTopping Price = " + (int)toppingPrice;
        
    }


    //Methods:

    // calculateOrderPrice Method: which calculates the price of the pizza order.
    public double calculateOrderPrice() {

        double price  =  (getNumberOfToppings() * getToppingPrice() * getPizzaSize());
        return price;
    }

    // printOrderInfo Method: which prints only the customer’s name and the calculated order price.
    public void printOrderInfo() {
   
    System.out.println(getCustomerName() + "       " + (int)calculateOrderPrice());
    }



    // this method will compare between the objects based on the calculatedOrderPrice , to sort it with using Collections.sort.
    @Override
    public int compareTo(PizzaOrder o) {

       int result  = 0;
       if(this.calculateOrderPrice() < o.calculateOrderPrice()){
        result  = -1;
       }else if(this.calculateOrderPrice() > o.calculateOrderPrice()){
        result  = 1;
       }else{
        result  = 0;
       }

     return result;
    }


}
