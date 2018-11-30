/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finalproject;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author casillas
 */
public class BankAccount {

     private ArrayList<Double>Deposit=new ArrayList<>();
     private ArrayList<Double>Withdraw=new ArrayList<>();
     private double balance;
     
     public void setDeposit(double deposit){
         Deposit.add(deposit);
     }
     
     public ArrayList<Double> getDeposit(){
         return this.Deposit;
     }
     
     public void setWithdraw(double withdraw){
         Withdraw.add(withdraw);
     }
     
     public ArrayList<Double>getWithdraw(){
         return this.Withdraw;
     }
     
     public void setBalance(){
         
       
         
         double all_deposit=0;
         double all_withdraw=0;
         
         
         for(double i:Deposit){
             all_deposit=all_deposit+i;
         }
         
         for(double i:Withdraw){
             all_withdraw=all_withdraw+i;
         }
         
         balance=all_deposit-all_withdraw;
         
     }
     
     public double getBalance(){
         return this.balance;
     }
     
     public void print_every_deposit(){
     
        for(double i:Deposit){
            System.out.println(i);
        }
     }
     
     public void print_every_withdraw(){
     
        for(double i:Withdraw){
            System.out.println(i);
        }
     }
     
     public void writeIntoFile(){
        File f=new File("bank.txt");
        
        try(
          PrintWriter output=new PrintWriter(f);
        ){
           output.print("deposit");
           output.print(" ");
           
           for(double i:Deposit){
               output.print(i);
               output.print(" ");
           }
           
           output.print("\n");
           
           output.print("withdraw");
           output.print(" ");
           
           for(double i:Withdraw){
               output.print(i);
               output.print(" ");
           }
           
          output.close();
           
        }catch(IOException ex){
        
           ex.printStackTrace();
        }
    }
     
     public void readFromFile(){
     
         File f=new File("bank.txt");
        try{
         Scanner sc=new Scanner(f);
         while(sc.hasNext()){
            System.out.print(sc.next());
            System.out.println("\t");
         }
        }catch(IOException e){
            e.printStackTrace();
        }
     }
     
}
