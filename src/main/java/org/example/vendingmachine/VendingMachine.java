package org.example.vendingmachine;


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
        this.state.selectSnack(this, snack );
    }








}
