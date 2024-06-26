package org.example.handlers;

public class SnickerHandler extends SnackDispenserHandler{
    public SnickerHandler(SnackDispenserHandler next) {
        super(next);
    }



    @Override
    public void handleRequest(RequestType requestType) {
        if (requestType.equals(RequestType.SNICKERS)){
            System.out.print("Dispensing some Snickers!\n");
        }
        else{
            System.out.print("I was passed from Snickers!\n");
            super.handleRequest(requestType);
        }
    }
}
