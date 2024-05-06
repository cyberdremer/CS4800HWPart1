import org.example.handlers.*;
import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;

public class HandlerTesting {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    private final PrintStream originalErr = System.err;

    @BeforeEach
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
        System.setErr(new PrintStream(errContent));
    }

    @AfterEach
    public void restoreStreams() {
        System.setOut(originalOut);
        System.setErr(originalErr);
    }

    @Test
    public void testOneChain(){
        SnackDispenserHandler chain = new CheetoHandler(null);
        String expectedOutput = "Dispensing cheetos";
        chain.handleRequest(RequestType.CHEETOS);
        assertEquals(expectedOutput, outContent.toString());
    }

    @Test
    public void testTwoChain() {
        SnackDispenserHandler chain = new CheetoHandler(new DoritosHandler(null));
        String expectedOutput = "I was passed from Cheetos!\n" +
                "Dispensing Doritoes!\n";
        chain.handleRequest(RequestType.DORITOS);
        assertEquals(expectedOutput, outContent.toString());
    }


    @Test
    public void testNonexistentItemInChain(){
        SnackDispenserHandler chain = new CheetoHandler(null);
        String expectedOutput = "I was passed from Cheetos!";
        chain.handleRequest(RequestType.KITKAT);
        assertEquals(expectedOutput, outContent.toString());
    }




}
