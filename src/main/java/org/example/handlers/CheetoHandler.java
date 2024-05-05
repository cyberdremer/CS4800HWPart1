package org.example.handlers;

public class CheetoHandler extends SnackDispenserHandler{
    public CheetoHandler(SnackDispenserHandler next) {
        super(next);
    }

    @Override
    public void handleRequest(RequestType requestType) {
        if (requestType.equals(RequestType.CHEETOS)){
            System.out.println("Dispensing cheetos");
        }
        else{
            System.out.println("I was passed from Cheetos!");
            super.handleRequest(requestType);
        }
    }
}
