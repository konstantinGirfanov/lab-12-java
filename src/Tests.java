import org.junit.*;

public class Tests {

    @Test
    public void TestOctal(){

        int actual = Integer.decode("070");
        int expected = 56;

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void TestNegativeOctal(){

        int actual = Integer.decode("-070");
        int expected = -56;

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void TestHexadecimal(){

        int expected = 15;
        int actual1 = Integer.decode("0xF");
        int actual2 = Integer.decode("#F");

        Assert.assertEquals(expected, actual1);
        Assert.assertEquals(expected, actual2);
    }
    @Test
    public void TestNegativeHexadecimal(){

        int expected = -15;
        int actual1 = Integer.decode("-0xF");
        int actual2 = Integer.decode("-#F");

        Assert.assertEquals(expected, actual1);
        Assert.assertEquals(expected, actual2);
    }

    @Test
    public void TestDecimal(){

        int expected = 10;
        int actual = Integer.decode("10");

        Assert.assertEquals(expected, actual);
    }
    @Test
    public void TestNegativeDecimal(){

        int expected = -10;
        int actual = Integer.decode("-10");

        Assert.assertEquals(expected, actual);
    }

    @Test (expected = NumberFormatException.class)
    public void TestEmpty(){

        Integer.decode("");
    }

    @Test (expected = NumberFormatException.class)
    public void TestOutOfMaxValue(){

        Integer.decode(String.valueOf((long)Integer.MAX_VALUE + 1));
    }

    @Test
    public void TestPlusSign(){

        int expected = 10;
        int actual = Integer.decode("+10");

        Assert.assertEquals(expected, actual);
    }
    @Test
    public void TestDoubleSigns(){

        try{
            Integer.decode("++5");
            Assert.fail();
        }
        catch (NumberFormatException e){
            Assert.assertNotEquals("", e.getMessage());
        }

        try{
            Integer.decode("+-5");
            Assert.fail();
        }
        catch (NumberFormatException e){
            Assert.assertNotEquals("", e.getMessage());
        }

        try{
            Integer.decode("-+5");
            Assert.fail();
        }
        catch (NumberFormatException e){
            Assert.assertNotEquals("", e.getMessage());
        }

        try{
            Integer.decode("--5");
            Assert.fail();
        }
        catch (NumberFormatException e){
            Assert.assertNotEquals("", e.getMessage());
        }
    }
}