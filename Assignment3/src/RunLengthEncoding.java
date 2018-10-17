public class RunLengthEncoding {

    public String encode(String source) {
        String encodedText = "";
        source = source.toLowerCase();
        for (int counter = 0; counter < source.length(); counter++) {
            int runLength = 1;
            while (counter + 1 < source.length() && source.charAt(counter) == source.charAt(counter + 1)) {
                runLength++;
                counter++;
            }
            encodedText += source.substring(counter, counter + 1) + runLength;
        }
        return encodedText;
    }

    public String decode(String source) {
        String decodedText = "";
        for (int counter = 0; counter < source.length(); counter += 2) {
            char element = source.charAt(counter);
            int runLength = Integer.parseInt(source.substring(counter + 1, counter + 2));
            for (int length = 0; length < runLength; length++) {
                decodedText += element;
            }
        }
        return decodedText;
    }
}
