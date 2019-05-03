package comp1110.ass2;

import comp1110.ass2.gui.Board;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;
import static org.junit.Assert.assertTrue;

public class RelativePositionTest {
    @Rule
    public Timeout globalTimeout = Timeout.millis(2000);

    @Test
    public void testUp() {
        for (String[] s:UP){
            testExpected(s[0],s[1],0);
        }
    }

    @Test
    public void testRight() {
        for (String[] s:RIGHT){
            testExpected(s[0],s[1],1);
        }
    }

    @Test
    public void testDown() {
        for (String[] s:DOWN){
            testExpected(s[0],s[1],2);
        }
    }

    @Test
    public void testLeft() {
        for (String[] s:LEFT){
            testExpected(s[0],s[1],3);
        }
    }

    @Test
    public void testBad() {
        for (String[] s:BAD){
            testExpected(s[0],s[1],-1);
        }
    }


    static final String[][] UP ={
            {"S0D40","A1C41"},
            {"B1G63","A3F62"},
            {"A1D04","S1C07"},
            {"A2F25","B2E26"},
            {"S3B31","A5A33"}
    };

    static final String[][] DOWN = {
            {"S3C51","A4D53"},
            {"A5F13","A4G16"},
            {"B1B35","A0C35"},
            {"B0E02","S3F07"},
            {"A2A43","A3B40"}
    };

    static final String[][] LEFT = {
            {"A0A16","S0A05"},
            {"A3C67","B2C57"},
            {"A4F45","B0F34"},
            {"S2G32","B2G23"},
            {"A0E20","A5E11"}
    };

    static final String[][] RIGHT = {
            {"S5D30","B2D42"},
            {"A3G51","S3G63"},
            {"B0B22","A5B37"},
            {"B1A33","S5A46"},
            {"B2F14","S1F25"}
    };

    static final String[][] BAD = {
            {"A1D34","S1C07"},
            {"A3A51","S3G63"},
            {"S3F51","A4D53"},
            {"A0E60","A5E11"},
            {"B1B63","A3C32"},
    };

    private void testExpected (String referencePlacement, String thePlacement,int expected){
        int result = Board.relativePosition(referencePlacement,thePlacement);
        assertTrue(thePlacement+" is "+toPositionString(expected)+" "+referencePlacement+" but returned "+result+"("+toPositionString(result)+")",expected==result);

    }

    private static String toPositionString (int positionInt){
        String position;
        switch (positionInt){
            case 0:
                position="above";
                break;
            case 1:
                position="on the left of";
                break;
            case 2:
                position="under";
                break;
            case 3:
                position="on the right of";
                break;
            default:
                position="NOT next to";
        }
        return position;
    }
}
