import org.junit.Assert;
import org.junit.Test;

public class DailerTest {
    @Test
    public void test1(){
        DailerApp dailerApp = new DailerApp();
        Assert.assertEquals("242",dailerApp.convertToNumber("aga"));
    }

    @Test
    public void test2(){
        DailerApp dailerApp = new DailerApp();
        Assert.assertEquals("874742",dailerApp.convertToNumber("Trisha"));
    }

    @Test
    public void searchWithNumpadTest(){
        Contact contact = new Contact("Trisha","","97432 74880","");
        Contact[] contacts= new Contact[1];
        contacts[0]=contact;
        DailerApp dailerApp = new DailerApp(contacts);
        Assert.assertEquals("Trisha", dailerApp.searchWithDialPad("874742"));
    }
    @Test
    public void searchWithNumpad(){
        Contact[] contacts= new Contact[4];
        contacts[0] = new Contact("Bradd","Pitt","96877 83241","");
        contacts[1] = new Contact("Trisha","","97432 74880","");
        contacts[2] = new Contact("Keanu","Reeves","96857 68789","");
        contacts[3] = new Contact("Vijay","Sethupathy","99490 83597","");
        DailerApp dailerApp = new DailerApp(contacts);
        Assert.assertEquals("Trisha", dailerApp.searchWithDialPad("874742"));
        Assert.assertEquals("BraddPitt", dailerApp.searchWithDialPad("7488"));
        Assert.assertEquals("VijaySethupathy",dailerApp.searchWithDialPad("99490"));
        Assert.assertEquals("Trisha",dailerApp.searchWithDialPad("74880"));
    }

}
