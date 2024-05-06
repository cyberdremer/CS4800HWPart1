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
        Snack selectedSnack = vendingMachine.getSelectedSnack();
        System.out.print("You have paid $" + payment + ".\n");
        if(ableToDispense(selectedSnack, payment)){
            System.out.print("Returning $" + (payment - selectedSnack.getPrice() ) + " to you.\n");
            vendingMachine.setState(new DispensingState());
        }
        else{
            System.out.println("Returning $" + payment +" to you.");
            if (!isAvailable(selectedSnack)){
                System.out.print(vendingMachine.getSelectedSnack().getName() + " is unavailable.\n");
            }
            else if (!hasEnoughMoney(selectedSnack, payment)){
                System.out.print("$" + payment + " is not enough for: " + vendingMachine.getSelectedSnack().getName() + "\n");

            }
            vendingMachine.setState(new IdleState());
        }

    }

    private boolean isAvailable(Snack snack){
        return snack.getQuantity() > 0;
    }

    private boolean hasEnoughMoney(Snack snack, int payment){
        return  snack.getPrice() <= payment;

    }

    private boolean ableToDispense(Snack snack, int price){
        return isAvailable(snack) && hasEnoughMoney(snack, price);

    }

    @Override
    public void dispenseSnack(VendingMachine vendingMachine) {
        System.out.println("Please insert payment!");

    }



}
