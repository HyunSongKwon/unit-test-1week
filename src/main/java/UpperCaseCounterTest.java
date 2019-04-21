
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class UpperCaseCounterTest {

    private  UpperCaseCounter upperCaseCounter = new UpperCaseCounter();

    @Test
    public void testNull() {
        String str = null;

        int result = upperCaseCounter.getNumberOfUpperCaseCharactersInString(str);
        assertTrue(result==0);
    }

    @Test
    public void testEmpty() {
        String str = "";
        int result = upperCaseCounter.getNumberOfUpperCaseCharactersInString(str);
        assertTrue(result==0);
    }

    @Test
    public void  test_uppber_ABC() {
        String str = "ABC";
        int result = upperCaseCounter.getNumberOfUpperCaseCharactersInString(str);
        System.out.println("result = " + result);
        assertTrue(result==3);
        assertFalse(result==2);
    }

    @Test
    public void  test_lower_abc() {
        String str = "abc";
        int result = upperCaseCounter.getNumberOfUpperCaseCharactersInString(str);
        System.out.println("result = " + result);
        assertTrue(result==0);
        assertFalse(result==1);

    }
}