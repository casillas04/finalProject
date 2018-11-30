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
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;

public class FinalProject extends Application{

      public void start(Stage newStage){
       
       HBox hbox=new HBox();
       hbox.setSpacing(10);
       hbox.setAlignment(Pos.CENTER);
       Button btNew=new Button("Make a deposit");
       Button btNew1=new Button("Make a withdraw");
       Button btNew2=new Button("write the record to file");
       Button btNew3=new Button("show the balance");
       Button btNew4=new Button("Quit");
       hbox.getChildren().addAll(btNew,btNew1,btNew2,btNew3,btNew4);
       
       BankAccount b=new BankAccount();
       DepositGui d=new DepositGui(b);
       WithdrawGui w=new WithdrawGui(b);
       BalanceGui balance=new BalanceGui(b);
       
       btNew.setOnAction((ActionEvent e) ->{
          d.start(newStage);
       }
      );
       
       btNew1.setOnAction((ActionEvent e) ->{
          w.start(newStage);
       }
     );
       
       btNew2.setOnAction((ActionEvent e)-> {
         b.writeIntoFile();
      });
       
       
       btNew3.setOnAction((ActionEvent e)->{
          balance.start(newStage);
       });
       
       btNew4.setOnAction((ActionEvent e)->{
           newStage.close();
       });
       
       Scene scene=new Scene(hbox,300,50);
       newStage.setTitle("bank application");
       newStage.setScene(scene);
       newStage.show();
    }
      
    public static void main(String []args){
       Application.launch(args);
    }
}
