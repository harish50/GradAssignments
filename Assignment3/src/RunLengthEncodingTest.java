import org.junit.Assert;
import org.junit.Test;

public class RunLengthEncodingTest {
    @Test
    public void encodeEmprtyString() {
        RunLengthEncoding runLengthEncoding = new RunLengthEncoding();
        Assert.assertEquals("", runLengthEncoding.encode(""));
    }

    @Test
    public void encodeSignleRunLengthString() {
        RunLengthEncoding runLengthEncoding = new RunLengthEncoding();
        Assert.assertEquals("x1j1k1a1", runLengthEncoding.encode("xjka"));
    }

}
