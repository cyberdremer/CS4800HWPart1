package org.example.states;

import org.example.handlers.RequestType;
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
        RequestType type = RequestType.valueOf(vendingMachine.getSelectedSnack().getName().toUpperCase());
        vendingMachine.getHandler().handleRequest(type);
        vendingMachine.deincrementSnack();
        vendingMachine.setState(new IdleState());

    }
}
