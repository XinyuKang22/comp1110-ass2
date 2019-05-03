package comp1110.ass2;

import comp1110.ass2.gui.Board;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;
import static org.junit.Assert.assertTrue;

public class RotatedTileInfoTest {
    @Rule
    public Timeout globalTimeout = Timeout.millis(2000);

    static final String[][] INFO = {
            {"S1A34","Highway","Railway","Railway","Railway","Station"},
            {"B2F64","Highway","Railway","Highway","Railway","Overpass"},
            {"B1D05","Railway","Highway","Nothing","Nothing","Station"},
            {"A2G31","Nothing","Railway","Railway","Railway","Normal"},
            {"S2A20","Highway","Highway","Highway","Highway","Normal"},
            {"S5D47","Railway","Highway","Railway","Highway","Station"},
            {"A5B64","Highway","Highway","Nothing","Nothing","Normal"}

    };

    String strLine = System.getProperty("line.separator");

    @Test
    public void testInfo (){
        for(String[] s:INFO){
            String[] result = Board.rotatedTileInfo(s[0]);
            boolean top = s[1].equals(result[0]);
            boolean right = s[2].equals(result[1]);
            boolean bottom = s[3].equals(result[2]);
            boolean left = s[4].equals(result[3]);
            boolean centre = s[5].equals(result[4]);
            assertTrue(strLine+"<The information of '"+s[0]+"'>"+strLine+"Expected: "+s[1]+", "+s[2]+", "+s[3]+", "+s[4]+", "+s[5]+strLine+"But got:  "+result[0]+
                    ", "+result[1]+", "+result[2]+", "+result[3]+", "+result[4],top && right && bottom && left && centre);
        }
    }

}
