package org.example.states;


import org.example.vendingmachine.Snack;
import org.example.vendingmachine.VendingMachine;

public class IdleState implements StateOfVendingMachine {


    @Override
    public void selectSnack(VendingMachine vendingMachine, String snack) {
        vendingMachine.setSnack(snack);
        vendingMachine.setState(new WaitingState());

    }

    @Override
    public void insertPayment(VendingMachine vendingMachine, int payment) {
        System.out.println("Please select a snack to purchase first!");
    }

    @Override
    public void dispenseSnack(VendingMachine vendingMachine) {
        System.out.println("Please select a snack to purchase first!");

    }
}
