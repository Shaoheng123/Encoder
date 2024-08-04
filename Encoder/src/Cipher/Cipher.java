package Cipher;
public class Cipher {

    private String referenceTable;
    private Character firstChar;
    String toEncode;


    public Cipher(String plainText, String encode) {
            toEncode = encode;
        }

    public String codec (String plainOrEncoded) {
        //remove first Character
        Encoder encoder = new Encoder(plainOrEncoded);
        if(toEncode.equals(CodecEnum.ENCODE.toString())) {
            return encoder.encode(plainOrEncoded);
        }
        return encoder.decode(plainOrEncoded);
    }



}
