package org.example.states;

import org.example.vendingmachine.Snack;
import org.example.vendingmachine.VendingMachine;

public interface StateOfVendingMachine{
    void selectSnack(VendingMachine vendingMachine, String snack);
    void insertPayment(VendingMachine vendingMachine, int payment);

    void dispenseSnack(VendingMachine vendingMachine);
}
