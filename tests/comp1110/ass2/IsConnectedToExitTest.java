package comp1110.ass2;
import comp1110.ass2.gui.Board;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class IsConnectedToExitTest {
    @Rule
    public Timeout globalTimeout = Timeout.millis(2000);

    static final String[] goodHighway = {"S0A54","B1D65","A4G10","S5G54","A5D07"};

    static final String[] goodRailway = {"A0A30","S3B65","B2F64","A2G31","S4F02"};

    static final String[] notAtExit = {"A5C37","S2A20","BOG64","B1E43","S4G01"};

    static final String[] noConnection = {"A0B63","A5A56","B0G31","B1D05","A1A17"};

    static final String[] wrongConnection = {"S1A34","A5B64","B2G30","A3F02","S3D01"};

    @Test
    public void testGoodHighway(){
        for(String s:goodHighway){
            assertTrue("Tile placement string '" + s + "' is connected to a highway exit but failed",Board.isConnectedToExit(s));
        }
    }

    @Test
    public void testGoodRailway(){
        for(String s:goodRailway){
            assertTrue("Tile placement string '" + s + "' is connected to a rail exit but failed",Board.isConnectedToExit(s));
        }
    }

    @Test
    public void testNotAtExit(){
        for(String s:notAtExit){
            assertFalse("Tile placement string '" + s + "' is NOT at an exit but passed",Board.isConnectedToExit(s));
        }
    }

    @Test
    public void testNoConnection(){
        for(String s:noConnection){
            assertFalse("Tile placement string '" + s + "' is NOT connected to an exit but passed",Board.isConnectedToExit(s));
        }
    }

    @Test
    public void testWrongConnection(){
        for(String s:wrongConnection){
            assertFalse("Tile placement string '" + s + "' is connected to a WRONG exit but passed",Board.isConnectedToExit(s));
        }
    }

}
