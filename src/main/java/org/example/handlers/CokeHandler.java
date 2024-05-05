package org.example.handlers;

public class CokeHandler extends SnackDispenserHandler{
    public CokeHandler(SnackDispenserHandler next) {
        super(next);
    }

    @Override
    public void handleRequest(RequestType requestType) {
        if (requestType.equals(RequestType.COKE)){
            System.out.println("Dispensing coke!");
        } else {
            System.out.println("I was passed from coke!");
            super.handleRequest(requestType);
            
        }
    }
}
