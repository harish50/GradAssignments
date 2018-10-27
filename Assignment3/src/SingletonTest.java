import org.junit.Assert;
import org.junit.Test;

public class SingletonTest {
    @Test
    public void singletonTestWithTwoInstances() {
        Singleton singleton = Singleton.INSTANCE;
        Singleton singleton1 = Singleton.INSTANCE;
        singleton.setValue(2);
        Assert.assertEquals(singleton.getValue(), singleton1.getValue());
    }
}
