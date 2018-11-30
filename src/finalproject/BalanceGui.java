/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finalproject;

import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

/**
 *
 * @author casillas
 */
public class BalanceGui {
     private BankAccount b=new BankAccount();
     private Button finish=new Button("finish");
     private TextField showBalance=new TextField();
     
     
     public BalanceGui(BankAccount b){
         this.b=b;
     }
     
     public void start(Stage newStage){
     
         GridPane gridpane=new GridPane();
         gridpane.setHgap(5);
         gridpane.setVgap(5);
         gridpane.add(new Label("Deposit:"), 0, 0);
         gridpane.add(showBalance, 1, 0);
         gridpane.add(finish,1,5);
         
         
         gridpane.setAlignment(Pos.CENTER);
         showBalance.setAlignment(Pos.BOTTOM_RIGHT);
         showBalance.setEditable(false);
         GridPane.setHalignment(finish,HPos.RIGHT);
         
         
         finish.setOnAction(e->displayBalance(b,newStage));
         
         Scene scene =new Scene(gridpane, 400, 250);
         newStage.setTitle("show the deposit");
         newStage.setScene(scene);
         newStage.show();
     }
     
     public void displayBalance(BankAccount b,Stage newStage){
     
         b.setBalance();
         showBalance.setText(String.format("$%.2f",b.getBalance()));
     }
}
