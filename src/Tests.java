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

    @Test
    public void TestEmpty() throws NumberFormatException{

        try{
            Integer.decode("");
            Assert.fail();
        }
        catch (NumberFormatException e){
            Assert.assertNotEquals("", e.getMessage());
        }
    }

    @Test
    public void TestNull() throws NullPointerException{

        try{
            Integer.decode(null);
            Assert.fail();
        }
        catch (NullPointerException e){
            Assert.assertNotEquals("", e.getMessage());
        }
    }

    @Test
    public void TestPlusSign(){

        int expected = 10;
        int actual = Integer.decode("+10");

        Assert.assertEquals(expected, actual);
    }
    @Test
    public void TestDoubleSigns() throws  NumberFormatException{

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

    @Test
    public void TestOutOfMaxValue() throws NumberFormatException{
        try{
            Integer.decode(String.valueOf((long)Integer.MAX_VALUE + 1));
            Assert.fail();
        }
        catch (NumberFormatException e){
            Assert.assertNotEquals("", e.getMessage());
        }
    }
}