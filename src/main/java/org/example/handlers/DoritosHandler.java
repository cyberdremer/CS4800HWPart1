package org.example.handlers;

public class DoritosHandler extends SnackDispenserHandler{
    public DoritosHandler(SnackDispenserHandler next) {
        super(next);
    }

    @Override
    public void handleRequest(RequestType requestType) {
        if (requestType.equals(RequestType.DORITOS)){
            System.out.print("Dispensing Doritoes!\n");
        }
        else{
            System.out.println("I was passed from Doritoes!");
            super.handleRequest(requestType);
        }
    }
}
