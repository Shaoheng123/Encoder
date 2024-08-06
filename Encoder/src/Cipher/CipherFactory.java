package Cipher;

public class CipherFactory {
    public Cipher createCipher(String plainOrEncoded, String toEncode){
        return new Cipher(plainOrEncoded, toEncode);
    }
}
