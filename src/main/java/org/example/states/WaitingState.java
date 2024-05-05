package org.example.states;


import org.example.vendingmachine.Snack;
import org.example.vendingmachine.VendingMachine;

public class WaitingState implements StateOfVendingMachine {
    @Override
    public void selectSnack(VendingMachine vendingMachine, String snack) {
        System.out.println("Please insert payment!");

    }

    @Override
    public void insertPayment(VendingMachine vendingMachine, int payment) {
        vendingMachine.setState(new DispensingState());

    }

    @Override
    public void dispenseSnack(VendingMachine vendingMachine) {
        System.out.println("Please insert payment!");

    }

}
