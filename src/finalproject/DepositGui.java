/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finalproject;

/**
 *
 * @author casillas
 */
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.geometry.HPos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

class DepositGui extends Application{
    
     private Button finish=new Button("finish");
     private TextField moneyEntry=new TextField();
     private BankAccount b=new BankAccount();
     
     public DepositGui(BankAccount b){
         this.b=b;
     }
     
     public void start(Stage newStage){
     
         GridPane gridpane=new GridPane();
         gridpane.setHgap(5);
         gridpane.setVgap(5);
         gridpane.add(new Label("Deposit:"), 0, 0);
         gridpane.add(moneyEntry, 1, 0);
         gridpane.add(finish,1,5);
         
         
         gridpane.setAlignment(Pos.CENTER);
         moneyEntry.setAlignment(Pos.BOTTOM_RIGHT);
         GridPane.setHalignment(finish,HPos.RIGHT);
         
         finish.setOnAction(e->addMoney(b,newStage));
         
         Scene scene =new Scene(gridpane, 400, 250);
         newStage.setTitle("make a deposit");
         newStage.setScene(scene);
         newStage.show();
     }
     
     public void addMoney(BankAccount b,Stage newStage){
         
         double money=Double.parseDouble(moneyEntry.getText());
         b.setDeposit(money);
     }
}
