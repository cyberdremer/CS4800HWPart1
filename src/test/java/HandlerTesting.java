import org.example.handlers.CheetoHandler;
import org.example.handlers.CokeHandler;
import org.example.handlers.RequestType;
import org.example.handlers.SnackDispenserHandler;
import org.junit.After;
import org.junit.Before;
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

    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
        System.setErr(new PrintStream(errContent));
    }

    @After
    public void restoreStreams() {
        System.setOut(originalOut);
        System.setErr(originalErr);
    }

    @Test
    public void testOneChain(){
        SnackDispenserHandler chain = new CheetoHandler(new CokeHandler(null));
        String expectedOutput = "Dispensing Cheeto";
        chain.handleRequest(RequestType.COKE);
        assertEquals(expectedOutput, errContent.toString());
    }
}
