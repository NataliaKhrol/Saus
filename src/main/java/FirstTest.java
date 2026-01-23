import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class FirstTest {
    //КРАТНО 3, ВОЗВРАЩАТЬ 'T'
    //КРАТНО 5, ВОЗВРАЩАТЬ 'M'
    //КРАТНО 3 И 5, ВОЗВРАЩАТЬ 'S'
    //ВОЗВРАЩАТЬ 'FAIL'

    public String trialCode(int number) {
        if (number % 3 == 0 && number % 5 == 0) {
            return "S";
        } else if (number % 5 == 0) {
            return "M";
        } else if (number % 3 == 0) {
            return "T";
        } else return "Fail";
    }

    @Test
    public void checkMethod() {
        String actualResult = trialCode(9);
        assertEquals(actualResult, "T");
    }

    @Test
    public void checkMethod1() {
        String actualResult = trialCode(25);
        assertEquals(actualResult, "M");
    }

    @Test
    public void checkMethod2() {
        String actualResult = trialCode(15);
        assertEquals(actualResult, "S");
    }

    @Test
    public void checkMethod3() {
        String actualResult = trialCode(1);
        assertEquals(actualResult, "Fail");
    }
}
