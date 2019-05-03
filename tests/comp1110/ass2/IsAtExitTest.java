package comp1110.ass2;

import comp1110.ass2.gui.Board;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class IsAtExitTest {
    @Rule
    public Timeout globalTimeout = Timeout.millis(2000);

    static final String[] atExit = {"S5A10","A3F62","B0G37","A0B64","B1D03"};

    static final String[] notAtExit = {"B1C21","S1B56","A4F30","S2A45","A0E11"};

    @Test
    public void testGood(){
        for(String s:atExit){
            assertTrue("Location string '" + s + "' is at exit but failed", Board.isAtExit(s));
        }
    }

    @Test
    public void testBad(){
        for(String s:notAtExit){
            assertFalse("Location string '" + s + "' is NOT at exit but passed", Board.isAtExit(s));
        }
    }

}
