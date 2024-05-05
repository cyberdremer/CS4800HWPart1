import org.example.vendingmachine.Snack;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SnackTesting {
    private Snack snack;
    @BeforeEach
    public void setup(){
        snack = new Snack("Coke", 2, 10);

    }

    @Test
    public void testQuantity(){
        int expectedQuantity = 10;
        assertEquals(expectedQuantity, snack.getQuantity());
    }

    @Test
    public void testQuantityAfterDispense(){
        int expectedQuantity = 9;
        snack.decreaseQuantity();
        assertEquals(expectedQuantity, snack.getQuantity());
    }


    @Test
    public void testGetPrice(){
        int expectedPrice = 2;
        assertEquals(expectedPrice, snack.getPrice());
    }
}
