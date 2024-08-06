package Cipher;

public class Encoder implements SymmetricEncryption {

    @Override
    public String encode(String plainText) {
        String encode = CodecEnum.ENCODE.toString();
        Codec codec = new Codec(plainText,encode);
        return codec.codec();
    }



    @Override
    public String decode(String encodedText) {
        String decode = CodecEnum.DECODE.toString();
        Codec codec = new Codec(encodedText,decode);
        return codec.codec();
    }


}
