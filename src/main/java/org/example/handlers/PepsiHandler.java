package org.example.handlers;

public class PepsiHandler extends SnackDispenserHandler{
    public PepsiHandler(SnackDispenserHandler next) {
        super(next);
    }

    @Override
    public void handleRequest(RequestType requestType) {
        if (requestType.equals(RequestType.PEPSI)){
            System.out.print("Dispensing Pepsi!\n");
        }
        else {
            System.out.print("I was passed from Pepsi\n");
            super.handleRequest(requestType);

        }
    }
}
