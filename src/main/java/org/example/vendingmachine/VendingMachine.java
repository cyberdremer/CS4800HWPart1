package org.example.vendingmachine;


import org.example.handlers.RequestType;
import org.example.handlers.SnackDispenserHandler;
import org.example.states.IdleState;
import org.example.states.StateOfVendingMachine;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class VendingMachine {
    private StateOfVendingMachine state = new IdleState();
    private SnackDispenserHandler handler;
    private Snack selectedSnack;

    private Map<String,Snack> snackMap;


    public VendingMachine(){
        this.snackMap = new HashMap<>();
    }

    public void addSnack(String name, Snack snack){
        if (snackMap.containsKey(name)){
            return;
        }
        snackMap.put(name, snack);
    }

    public void setState(StateOfVendingMachine state){
        this.state = state;

    }


    public Snack getSelectedSnack() {
        return selectedSnack;
    }

    public void setChainOfResponsibility(SnackDispenserHandler handler){
        this.handler = handler;
    }

    public SnackDispenserHandler getHandler() {
        return handler;
    }

    public StateOfVendingMachine getState(){
        return this.state;
    }

    public void insertPayment(int payment){
        this.state.insertPayment(this, payment);
    }

    public void dispenseSnack(){
        this.state.dispenseSnack(this);
    }

    public void selectSnack(String snack){
        state.selectSnack(this, snack);

    }

    public void setSnack(String snack){
        selectedSnack = snackMap.get(snack);

    }

    public void deincrementSnack(){
        selectedSnack.decreaseQuantity();

    }










}
