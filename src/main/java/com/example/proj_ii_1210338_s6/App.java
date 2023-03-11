package com.example.proj_ii_1210338_s6;

import java.util.ArrayList;
import java.util.Collections;
import javafx.application.Application;
import javafx.css.Size;
import javafx.fxml.FXMLLoader;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

import java.io.IOException;

public class App extends Application {


    // to make an ArrayList and add the elements in it :
    ArrayList<PizzaOrder> orders = new ArrayList<PizzaOrder>();


    @Override
    public void start(Stage stage) throws IOException {



        // create a grid pane that hold all the nods inside it .
        GridPane gp = new GridPane();
        gp.setAlignment(Pos.TOP_CENTER);
        gp.setHgap(0);
        gp.setVgap(20);


        // welcome label:
        Label laWlcm = new Label("Welcome to IT Pizza System");
        laWlcm.setFont(Font.font("Tahoma", FontWeight.BOLD,50));
        laWlcm.setTextFill(Color.ORANGE);
        gp.add(laWlcm,0,1);


        // Select order Type label:
        Label laSot = new Label("Select order Type:");
        laSot.setFont(Font.font("Tahoma", FontWeight.BOLD,20));

        //order type (COMBO BOX):
        String[] oTList  = {"ToGo", "Delivery", "Seated"};
        ComboBox oTCB = new ComboBox();
        oTCB.getItems().addAll(oTList);
        oTCB.setValue("ToGo");
        oTCB.getSelectionModel().selectFirst();
        oTCB.setMaxWidth(300);




        //VBOX 1:
        VBox vb1 = new VBox(10);
        vb1.getChildren().addAll(laSot,oTCB);
        gp.add(vb1 ,0,3);
        GridPane.setHalignment(vb1,HPos.LEFT);


        // Customer Name:
        Label laName = new Label("Customer Name:");
        laName.setFont(Font.font("Tahoma", FontWeight.BOLD,20));

        //Customer Name Text Field:
        TextField cNameTF = new TextField();
        cNameTF.setMaxWidth(300);
        cNameTF.setPromptText("enter the customer name");



        //VBOX 2:
        VBox vb2 = new VBox(10);
        vb2.getChildren().addAll(laName,cNameTF);
        gp.add(vb2,0,5); ///  row/coulum
        GridPane.setHalignment(vb2,HPos.LEFT);


        // pizza size label:
        Label laSize = new Label("Pizza Size:");
        laSize.setFont(Font.font("Tahoma", FontWeight.BOLD,20));

        //radio button pizzas size
        ToggleGroup tg = new ToggleGroup();
        RadioButton r1 = new RadioButton("Small");
        r1.setSelected(true);
        r1.setTextFill(Color.RED);
        r1.setFont(Font.font("Tahoma", FontWeight.BOLD,20));
        RadioButton r2 = new RadioButton("Meduim");
        r2.setTextFill(Color.ORANGE);
        r2.setFont(Font.font("Tahoma", FontWeight.BOLD,20));
        RadioButton r3 = new RadioButton("Large");
        r3.setTextFill(Color.MIDNIGHTBLUE);
        r3.setFont(Font.font("Tahoma", FontWeight.BOLD,20));




        //HBOX 1:
        HBox hb1 = new HBox(10);
        hb1.getChildren().addAll(r1,r2,r3);

        //HBOX 2:
        HBox hb2 = new HBox(300);
        hb2.getChildren().addAll(laSize,hb1);
        gp.add(hb2,0,7); ///  row/coulum
        GridPane.setHalignment(hb2,HPos.LEFT);

        //toping price label
        Label laTP = new Label("Toping price:");
        laTP.setFont(Font.font("Tahoma", FontWeight.BOLD,20));

        //toping price Text Field:
        TextField TPTF = new TextField();
        TPTF.setText("10");
        TPTF.setMaxWidth(200);
        TPTF.setPromptText("enter the toping price");


        //VBOX 3:
        VBox vb3 = new VBox(10);
        vb3.getChildren().addAll(laTP,TPTF);


        //list of tooping  label:
        Label laListOfTopping = new Label("list of tooping:");
        laListOfTopping.setFont(Font.font("Tahoma", FontWeight.BOLD,20));


        //Checkbox list of toopings:
        CheckBox cb1 = new CheckBox("Onions");
        cb1.setTextFill(Color.RED);
        cb1.setFont(Font.font("Tahoma", FontWeight.BOLD,15));
        CheckBox cb2 = new CheckBox("Olives");
        cb2.setTextFill(Color.RED);
        cb2.setFont(Font.font("Tahoma", FontWeight.BOLD,15));
        CheckBox cb3 = new CheckBox("Green peppers");
        cb3.setTextFill(Color.RED);
        cb3.setFont(Font.font("Tahoma", FontWeight.BOLD,15));
        CheckBox cb4 = new CheckBox("extra cheese");
        cb4.setTextFill(Color.RED);
        cb4.setFont(Font.font("Tahoma", FontWeight.BOLD,15));


        //VBOX 4:
        VBox vb4 = new VBox(10);
        vb4.getChildren().addAll(laListOfTopping,cb1,cb2,cb3,cb4);


        //HBOX 3 :
        HBox hb3 = new HBox(250);
        hb3.getChildren().addAll(vb3,vb4);
        gp.add(hb3,0,8); ///  row/coulum

        Button buProcessOrder = new Button("ProcessOrder");
        Button buPrintOrders = new Button("PrintOrders");
        Button buReset = new Button("Reset");


        //HBOX 4 :
        HBox hb4 = new HBox(250);
        hb4.getChildren().addAll(buProcessOrder,buPrintOrders,buReset);
        gp.add(hb4,0,18); ///  row/coulum
        GridPane.setHalignment(hb4,HPos.LEFT);

        // Price label:
        Label laPrice = new Label("Price:");
        laPrice.setFont(Font.font("Tahoma", FontWeight.BOLD,30));
        gp.add(laPrice,0,15); ///  row/coulum
        GridPane.setHalignment(laPrice,HPos.LEFT);



        //Trip rate label
        Label laTR = new Label("Trip Rate");
        laTR.setFont(Font.font("Tahoma", FontWeight.BOLD,20));

        //Trip rate Text Field:
        TextField TRTF = new TextField();
        TRTF.setText("0.0");
        TRTF.setMaxWidth(200);
        TRTF.setPromptText("enter the Trip Rate");

        //HBOX 5:
        HBox hb5 = new HBox(20);
        hb5.getChildren().addAll(laTR,TRTF);

        // zone label:
        Label laZone = new Label("Zone:");
        laZone.setFont(Font.font("Tahoma", FontWeight.BOLD,20));

        //radio button zone:
        ToggleGroup tg3 = new ToggleGroup();
        RadioButton rBtn1 = new RadioButton("1");
        rBtn1.setSelected(true);
        rBtn1.setTextFill(Color.RED);
        rBtn1.setFont(Font.font("Tahoma", FontWeight.BOLD,20));
        RadioButton rBtn2 = new RadioButton("2");
        rBtn2.setTextFill(Color.ORANGE);
        rBtn2.setFont(Font.font("Tahoma", FontWeight.BOLD,20));
        RadioButton rBtn3 = new RadioButton("3");
        rBtn3.setTextFill(Color.MIDNIGHTBLUE);
        rBtn3.setFont(Font.font("Tahoma", FontWeight.BOLD,20));
        RadioButton rBtn4 = new RadioButton("4");
        rBtn4.setTextFill(Color.BLUE);
        rBtn4.setFont(Font.font("Tahoma", FontWeight.BOLD,20));
        tg3.getToggles().addAll(rBtn1,rBtn2,rBtn3,rBtn4);


        //HBOX 6:
        HBox hb6 = new HBox(10);
        hb6.getChildren().addAll(laZone,rBtn1,rBtn2,rBtn3,rBtn4);

        //HBOX 7:
        HBox hb7 = new HBox(140);
        hb7.getChildren().addAll(hb5,hb6);


        //number of people label
        Label laNP = new Label("number of people");
        laNP.setFont(Font.font("Tahoma", FontWeight.BOLD,20));

        //number of people  Text Field:
        TextField nPTF = new TextField();
        nPTF.setText("1");
        nPTF.setMaxWidth(150);
        nPTF.setPromptText("enter number of people");


        // HBox 8:
        HBox hb8 = new HBox(20);
        hb8.getChildren().addAll(laNP,nPTF);

        //service charge label
        Label laSC = new Label("Service Charge");
        laSC.setFont(Font.font("Tahoma", FontWeight.BOLD,20));

        //service charge  Text Field:
        TextField sCTF = new TextField();
        sCTF.setText("0.0");
        sCTF.setMaxWidth(100);
        sCTF.setPromptText("enter service charge");


        // HBox 9:
        HBox hb9 = new HBox(20);
        hb9.getChildren().addAll(laSC,sCTF);


        // HBox 10:
        HBox hb10 = new HBox(80);
        hb10.getChildren().addAll(hb8,hb9);


        // events and actions :
        if (oTCB.getValue() == "ToGo"){

            gp.getChildren().removeIf( node -> GridPane.getColumnIndex(node) == 0 && GridPane.getRowIndex(node) == 12);
            buProcessOrder.setOnAction(ev-> {

                String customerName = cNameTF.getText();
                double topping_price = Double.parseDouble(TPTF.getText());
                int size = 1;
                int nToppings = 0;

                // to know the selected pizza size:
                if (r2.isSelected()) {
                    size = 2;  //Meduim
                } else if (r3.isSelected()) {
                    size = 3; //large
                }

                // to know the numbers of the toppings :
                if (cb1.isSelected()) {
                    nToppings++;
                }
                if (cb2.isSelected()) {
                    nToppings++;
                }
                if (cb3.isSelected()) {
                    nToppings++;
                }
                if (cb4.isSelected()) {
                    nToppings++;
                }

                orders.add(new ToGo(customerName, size, nToppings, topping_price));
                String price = String.valueOf(orders.get(orders.size()-1).calculateOrderPrice());
                laPrice.setText("Price: "+price);


            });

        }


        oTCB.setOnAction( e-> {

            if(oTCB.getValue() == "Delivery"){

                gp.getChildren().removeIf( node -> GridPane.getColumnIndex(node) == 0 && GridPane.getRowIndex(node) == 12);
                gp.add(hb7,0,12); ///  coulum/row
                GridPane.setHalignment(hb7,HPos.LEFT);   //  mybe remove?

                buProcessOrder.setOnAction(ev->{

                    // save the data thats in text field
                    String customerName = cNameTF.getText();
                    String topping_price = TPTF.getText();
                    String trip_rate = TRTF.getText();

                    int size = 1;
                    int nToppings  = 0;
                    int zone = 1;

                    // to know the selected pizza size:
                    if(r2.isSelected()) {
                        size = 2;  //Meduim
                    } else if (r3.isSelected()) {
                        size = 3; //large
                    }

                    // to know the numbers of the toppings :
                    if(cb1.isSelected()){
                        nToppings++;
                    }
                    if(cb2.isSelected()){
                        nToppings++;
                    }
                    if(cb3.isSelected()){
                        nToppings++;
                    }
                    if(cb4.isSelected()){
                        nToppings++;
                    }

                    // to know the selected zone :
                    if(rBtn2.isSelected()) {
                        zone = 2;  //zone 2
                    } else if (rBtn3.isSelected()) {
                        zone = 3; //zone 3
                    } else if (rBtn4.isSelected()) {
                        zone = 4;  // zone 4
                    }


                    //create a delivery object
                    orders.add(new Delivery(customerName,size,nToppings,Double.parseDouble(topping_price),Double.parseDouble(trip_rate),zone));
                    String price = String.valueOf(orders.get(orders.size()-1).calculateOrderPrice());
                    laPrice.setText("Price: "+price);



                });

            }else if(oTCB.getValue() == "Seated"){

                gp.getChildren().removeIf( node -> GridPane.getColumnIndex(node) == 0 && GridPane.getRowIndex(node) == 12);
                gp.add(hb10,0,12); ///  row/coulum
                GridPane.setHalignment(hb10,HPos.LEFT);   //  mybe remove?


                buProcessOrder.setOnAction(ev->{

                    // save the data thats in text field
                    String customerName = cNameTF.getText();
                    String topping_price = TPTF.getText();
                    String numberOfPeople = nPTF.getText();
                    String serviceCharge = sCTF.getText();

                    int size = 1;
                    int nToppings  = 0;

                    // to know the selected pizza size:
                    if(r2.isSelected()) {
                        size = 2;  //Meduim
                    } else if (r3.isSelected()) {
                        size = 3; //large
                    }

                    // to know the numbers of the toppings :
                    if(cb1.isSelected()){
                        nToppings++;
                    }
                    if(cb2.isSelected()){
                        nToppings++;
                    }
                    if(cb3.isSelected()){
                        nToppings++;
                    }
                    if(cb4.isSelected()){
                        nToppings++;
                    }

                    //create a seated object:
                    orders.add(new Seated (customerName, size,nToppings,Double.parseDouble(topping_price),Double.parseDouble(serviceCharge),Integer.parseInt(numberOfPeople)));
                    String price = String.valueOf(orders.get(orders.size()-1).calculateOrderPrice());
                    laPrice.setText("Price: "+price);
                });

            }else if(oTCB.getSelectionModel().getSelectedItem() == "ToGo") {


                gp.getChildren().removeIf( node -> GridPane.getColumnIndex(node) == 0 && GridPane.getRowIndex(node) == 12);
                buProcessOrder.setOnAction(ev-> {

                    String customerName = cNameTF.getText();
                    double topping_price = Double.parseDouble(TPTF.getText());
                    int size = 1;
                    int nToppings = 0;

                    // to know the selected pizza size:
                    if (r2.isSelected()) {
                        size = 2;  //Meduim
                    } else if (r3.isSelected()) {
                        size = 3; //large
                    }

                    // to know the numbers of the toppings :
                    if (cb1.isSelected()) {
                        nToppings++;
                    }
                    if (cb2.isSelected()) {
                        nToppings++;
                    }
                    if (cb3.isSelected()) {
                        nToppings++;
                    }
                    if (cb4.isSelected()) {
                        nToppings++;
                    }

                    orders.add(new ToGo(customerName, size, nToppings, topping_price));
                    String price = String.valueOf(orders.get(orders.size()-1).calculateOrderPrice());
                    laPrice.setText("Price: "+price);


                });
            }
        });

        // create a grid pane that hold all the nods inside it .
        GridPane gp2 = new GridPane();
        gp2.setAlignment(Pos.TOP_CENTER);
        gp2.setHgap(10);
        gp2.setVgap(20);

        Scene OrdersScene = new Scene(gp2,800,900);

        Stage OrdersStage = new Stage();
        OrdersStage.setTitle("orders");
        OrdersStage.setScene(OrdersScene);


        buPrintOrders.setOnAction( e-> {

            gp2.getChildren().clear();   // FROM REMOVE TO ------> CLEAR

            // to Sorts the orders based on their calculated order price.
             sortOrders(orders);

            // to print the orders (Customer Name | price):
            int n = 2;
            int no=1;

            for(PizzaOrder o: orders){
                gp2.add(new Label("order_" +no+ ":         " +"Name: "+o.getCustomerName() + "             price: " + o.calculateOrderPrice()),0,n);
                n++;
                no++;
            }

            OrdersStage.show();

        });



        buReset.setOnAction( e-> {

            // return all the nodes to deffult:
            oTCB.getSelectionModel().selectFirst();
            cNameTF.setText("");
            TPTF.setText("10");
            r1.setSelected(true);
            cb1.setSelected(false);
            cb2.setSelected(false);
            cb3.setSelected(false);
            cb4.setSelected(false);
            TRTF.setText("0.0");
            rBtn1.setSelected(true);
            nPTF.setText("1");
            sCTF.setText("0.0");
            laPrice.setText("Price:");
            // remove all the orders list elements:
            orders.removeAll(orders);
            gp2.getChildren().clear();


        });



        Scene scene = new Scene(gp, 1000, 1500);
        stage.setTitle("IT Pizza!");
        stage.setScene(scene);
        stage.show();
    }





    public static void main(String[] args) {
        launch();

    }


  //  Mthods:


 //   sortOrders method: which takes an ArrayList of type PizzaOrder as an argument and sorts it.
    static void sortOrders(ArrayList<PizzaOrder> arr){
        Collections.sort(arr);
    }


 //   calculateTotalOrdersPrice method: which takes an ArrayList of type PizzaOrder as an
 //  argument and returns the total price of all the orders in that ArrayList.
    static double calculateTotalOrdersPrice(ArrayList<PizzaOrder> arr){

        double totalSum = 0 ;
        for(PizzaOrder o: arr){
            totalSum +=  o.calculateOrderPrice();
        }

        return totalSum;
    }

}