package encryptdecrypt.strategy;

public interface EncryptionStrategy {
    String encode(String message, int key);

    String decode(String message, int key);
}