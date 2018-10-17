public class RunLengthEncoding {

    public String encode(String source) {
        String encodedText = "";
        for (int counter = 0; counter < source.length(); counter++) {
            encodedText = encodedText + (source.charAt(counter) + "1");
        }
        return encodedText;
    }
}
