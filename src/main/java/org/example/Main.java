package org.example;

import org.example.handlers.*;
import org.example.vendingmachine.Snack;
import org.example.vendingmachine.VendingMachine;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        VendingMachine vendingMachine = new VendingMachine();
        SnackDispenserHandler chain = new CokeHandler(new PepsiHandler(new CheetoHandler(new DoritosHandler(new KitkatHandler(new SnickerHandler(null))))));
        vendingMachine.setChainOfResponsibility(chain);
        vendingMachine.addSnack("Pepsi", new Snack("Pepsi", 2, 1));
        vendingMachine.addSnack("KitKat", new Snack("KitKat" , 4, 3));
        vendingMachine.addSnack("Coke", new Snack("Coke", 3, 5));
        vendingMachine.addSnack("Doritos", new Snack("Doritos", 5, 20));
        vendingMachine.addSnack("Snickers", new Snack("Snickers", 6, 24));
        vendingMachine.addSnack("Cheeto", new Snack("Cheetos", 5, 10));

        vendingMachine.selectSnack("KitKat");
        vendingMachine.insertPayment(4);
        vendingMachine.dispenseSnack();


        vendingMachine.selectSnack("Pepsi");
        vendingMachine.insertPayment(4);
        vendingMachine.dispenseSnack();

        vendingMachine.selectSnack("KitKat");
        vendingMachine.insertPayment(10);
        vendingMachine.dispenseSnack();

        vendingMachine.selectSnack("Snickers");
        vendingMachine.insertPayment(10);
        vendingMachine.dispenseSnack();

        vendingMachine.selectSnack("Snickers");
        vendingMachine.insertPayment(1);
        vendingMachine.dispenseSnack();


        vendingMachine.selectSnack("Pepsi");
        vendingMachine.insertPayment(3);
        vendingMachine.dispenseSnack();



    }
}