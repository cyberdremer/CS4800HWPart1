package org.example.handlers;

public abstract class SnackDispenserHandler {
    private SnackDispenserHandler next;
    public SnackDispenserHandler(SnackDispenserHandler next){
        this.next = next;

    }

    public void handleRequest(RequestType requestType){
        if (next != null){
            next.handleRequest(requestType);
        }

    }

}
