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
        for (int counter = 0; counter < source.length(); counter++) {
            char element = source.charAt(counter);
            int start = counter + 1;
            while (counter + 1 < source.length() && Character.isDigit(source.charAt(counter + 1))) {
                counter++;
            }
            int runLength = Integer.parseInt(source.substring(start, counter + 1));
            for (int length = 0; length < runLength; length++) {
                decodedText += element;
            }
        }
        return decodedText;
    }

}
