package encryptdecrypt.strategy;

public class UnicodeStrategy implements EncryptionStrategy {
    @Override
    public String encode(String message, int key) {
        StringBuilder builder = new StringBuilder();
        for (char ch : message.toCharArray()) {
            if (ch >= 32 && ch <= 127) {
                int startPos = ch - 32;
                int newPos = (startPos + key) % 96;
                if (newPos < 0) {
                    newPos += 96;
                }
                char newChar = (char) (newPos + 32);
                builder.append(newChar);
            }
        }
        return builder.toString();
    }

    @Override
    public String decode(String message, int key) {
        return encode(message, 96 - (key % 96));

    }
}