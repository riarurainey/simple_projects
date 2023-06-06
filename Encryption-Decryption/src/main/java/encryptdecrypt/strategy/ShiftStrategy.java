package encryptdecrypt.strategy;



public class ShiftStrategy implements EncryptionStrategy {
    @Override
    public String encode(String message, int key) {
        StringBuilder builder = new StringBuilder();
        for (char ch : message.toCharArray()) {
            if (ch != ' ') {
                int startPos = ch - 'a';
                int newPos = (startPos + key) % 26;
                char newChar = (char) ('a' + newPos);
                builder.append(newChar);
            } else {
                builder.append(ch);
            }
        }
        return builder.toString();
    }

    @Override
    public String decode(String message, int key) {
        return encode(message, 26 - (key % 26));
    }
}