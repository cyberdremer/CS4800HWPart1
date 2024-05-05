package VendingMachine;

import States.IdleState;
import States.StateOfVendingMachine;

import java.util.ArrayList;
import java.util.List;

public class VendingMachine {
    private StateOfVendingMachine idleState = new IdleState();

    private List<Snack> snackList;


    VendingMachine(){
        this.snackList = new ArrayList<>();
    }


}
