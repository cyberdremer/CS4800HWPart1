package org.example.handlers;

public class DoritosHandler extends SnackDispenserHandler{
    public DoritosHandler(SnackDispenserHandler next) {
        super(next);
    }

    @Override
    public void handleRequest(RequestType requestType) {
        if (requestType.equals(RequestType.DORITOS)){
            System.out.print("Dispensing Doritos!\n");
        }
        else{
            System.out.print("I was passed from Doritos!\n");
            super.handleRequest(requestType);
        }
    }
}
