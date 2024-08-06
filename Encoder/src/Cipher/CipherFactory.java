package Cipher;

public class CipherFactory implements Factory {
    private static CipherFactory instance;
    public static CipherFactory getInstance(){
        if(instance == null){
            instance = new CipherFactory();
        }
        return instance;
    }
    public Cipher createCipher(String plainOrEncoded, String toEncode){
        return new Cipher(plainOrEncoded, toEncode);
    }


}
