package org.example.handlers;

public class PepsiHandler extends SnackDispenserHandler{
    public PepsiHandler(SnackDispenserHandler next) {
        super(next);
    }

    @Override
    public void handleRequest(RequestType requestType) {
        if (requestType.equals(RequestType.PEPSI)){
            System.out.println("Dispensing Pepsi! ");
        }
        else {
            System.out.println("I was passed from Pepsi");
            super.handleRequest(requestType);

        }
    }
}
