import org.example.handlers.*;
import org.example.states.DispensingState;
import org.example.states.IdleState;
import org.example.states.StateOfVendingMachine;
import org.example.states.WaitingState;
import org.example.vendingmachine.Snack;
import org.example.vendingmachine.VendingMachine;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StateTesting {
    private VendingMachine vendingMachine;
    @BeforeEach
    public void setVendingMachine(){
        SnackDispenserHandler chain = new CokeHandler(new PepsiHandler(new CheetoHandler(new DoritosHandler(new KitkatHandler(new SnickerHandler(null))))));
        vendingMachine = new VendingMachine();
        vendingMachine.addSnack("Pepsi", new Snack("Pepsi", 2, 3));
        vendingMachine.addSnack("Kitkat", new Snack("Kitkat", 5, 0));
        vendingMachine.addSnack("Coke", new Snack("Coke", 3, 3));
        vendingMachine.addSnack();
        vendingMachine.setChainOfResponsibility(chain);

    }
    @Test
    public void testIdleState(){
        StateOfVendingMachine state =  vendingMachine.getState();
        assertEquals(state.getClass(), IdleState.class);


    }

    @Test
    public void testStateAfterIdle(){
        StateOfVendingMachine state;
        vendingMachine.selectSnack("Pepsi");
        state = vendingMachine.getState();
        assertEquals(state.getClass(), WaitingState.class);
    }


    @Test
    public void testStateAfterWaiting(){
        StateOfVendingMachine state;
        vendingMachine.selectSnack("Pepsi");
        vendingMachine.insertPayment(6);
        state = vendingMachine.getState();
        assertEquals(state.getClass(), DispensingState.class);
    }

    @Test
    public void testIdleAfterDispensing(){
        StateOfVendingMachine state;
        vendingMachine.selectSnack("Pepsi");
        vendingMachine.insertPayment(6);
        vendingMachine.dispenseSnack();
        state = vendingMachine.getState();
        assertEquals(state.getClass(), IdleState.class);

    }


    @Test
    public void testStateDispensingForSoldout(){
        StateOfVendingMachine state;
        vendingMachine.selectSnack("Kitkat");
        vendingMachine.insertPayment(4);
        state = vendingMachine.getState();
        assertEquals(state.getClass(), IdleState.class);
    }


    @Test
    public void testStateForRecentlySoldoutItem(){
        StateOfVendingMachine state;
        vendingMachine.addSnack("Cheeto", new Snack("Cheetos", 2, 1));
        vendingMachine.selectSnack("Cheeto");
        vendingMachine.insertPayment(4);
        vendingMachine.dispenseSnack();

        vendingMachine.selectSnack("Cheeto");
        vendingMachine.insertPayment(2);
        state = vendingMachine.getState();
        assertEquals(state.getClass(), IdleState.class);


    }


    @Test
    public void testStateForInsufficientPayment(){
        StateOfVendingMachine state;
        vendingMachine.selectSnack("Pepsi");
        vendingMachine.insertPayment(1);
        state = vendingMachine.getState();
        assertEquals(state.getClass(), IdleState.class);

    }

}
