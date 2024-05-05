import org.example.vendingmachine.VendingMachine;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StateTesting {
    private VendingMachine vendingMachine;
    @BeforeEach
    public void setVendingMachine(){
        vendingMachine = new VendingMachine();
    }
    @Test
    public void testDispensingState(){
        vendingMachine.dispenseSnack();



    }

}
