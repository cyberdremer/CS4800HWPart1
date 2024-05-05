package org.example.handlers;

public class KitkatHandler extends SnackDispenserHandler{
    public KitkatHandler(SnackDispenserHandler next) {
        super(next);
    }

    @Override
    public void handleRequest(RequestType requestType) {
        if (requestType.equals(RequestType.KITKAT)){
            System.out.print("Dispensing Kitkat\n");
        }
        else{
            System.out.println("I was passed from Kitkat!");
            super.handleRequest(requestType);
        }
    }
}
