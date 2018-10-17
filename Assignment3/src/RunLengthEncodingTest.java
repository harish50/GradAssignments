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

    @Test
    public void encodeMultiRunLengthString() {
        RunLengthEncoding runLengthEncoding = new RunLengthEncoding();
        Assert.assertEquals("k2a3s1d2a1", runLengthEncoding.encode("KKaaasddA"));
    }

    @Test
    public void decodeEmptyString() {
        RunLengthEncoding runLengthEncoding = new RunLengthEncoding();
        Assert.assertEquals("", runLengthEncoding.decode(""));
    }

    @Test
    public void decodeSignleRunLengthString() {
        RunLengthEncoding runLengthEncoding = new RunLengthEncoding();
        Assert.assertEquals("abcd", runLengthEncoding.decode("a1b1c1d1"));
    }

    @Test
    public void decodeSingleDigitRunLengthString() {
        RunLengthEncoding runLengthEncoding = new RunLengthEncoding();
        Assert.assertEquals("rrrjjabbbbcc", runLengthEncoding.decode("r3j2a1b4c2"));
    }

    @Test
    public void decodeMultiDigitRunLengthString() {
        RunLengthEncoding runLengthEncoding = new RunLengthEncoding();
        Assert.assertEquals("eeeeeeeeeeffff", runLengthEncoding.decode("e10f4"));
        Assert.assertEquals("gggggggggggggggg", runLengthEncoding.decode("g16"));
    }

}
