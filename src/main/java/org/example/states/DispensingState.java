package org.example.states;

import org.example.vendingmachine.Snack;
import org.example.vendingmachine.VendingMachine;

public class DispensingState implements StateOfVendingMachine{
    @Override
    public void selectSnack(VendingMachine vendingMachine, String snack) {
        System.out.println("Please wait for the snack to dispense!");

    }

    @Override
    public void insertPayment(VendingMachine vendingMachine, int payment) {
        System.out.println("Please wait for the snack to dispense!");

    }

    @Override
    public void dispenseSnack(VendingMachine vendingMachine) {
        vendingMachine.setState(new IdleState());

    }
}
