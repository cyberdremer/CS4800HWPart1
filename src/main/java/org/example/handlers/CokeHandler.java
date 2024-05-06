package org.example.handlers;

public class CokeHandler extends SnackDispenserHandler{
    public CokeHandler(SnackDispenserHandler next) {
        super(next);
    }

    @Override
    public void handleRequest(RequestType requestType) {
        if (requestType.equals(RequestType.COKE)){
            System.out.print("Dispensing Coke!\n");
        } else {
            System.out.print("I was passed from Coke!\n");
            super.handleRequest(requestType);
            
        }
    }
}
