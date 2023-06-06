package encryptdecrypt.strategy;

public class Context {
    private EncryptionStrategy encryptionStrategy;

    public void setStrategy(EncryptionStrategy encryptionStrategy) {
        this.encryptionStrategy = encryptionStrategy;
    }

    public String encode(String message, int key) {
        return this.encryptionStrategy.encode(message, key);
    }

    public String decode(String message, int key) {
        return this.encryptionStrategy.decode(message, key);
    }


}