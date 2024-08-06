package Cipher;
public class Cipher {


    private final String toEncode;
    private final String plainOrEncoded;
    public Cipher(String plainOrEncoded,String toEncode) {
        this.plainOrEncoded = plainOrEncoded;
        this.toEncode = toEncode;
    }

    public String codec () {
        //remove first Character
        Encoder encoder = new Encoder();
        if(toEncode.equals(CodecEnum.ENCODE.toString())) {
            return encoder.encode(plainOrEncoded);
        }
        return encoder.decode(plainOrEncoded);
    }


}
