package Cipher;

public class Encoder implements SymmetricEncryption {


    private String textToCodec;

    public Encoder(String textToCodec) {
        this.textToCodec = textToCodec;
    }

    @Override
    public String encode(String textToEncode) {
        String encode = CodecEnum.ENCODE.toString();
        Codec codec = new Codec(textToEncode,encode);
        return codec.codec(textToEncode);
    }

    @Override
    public String decode(String textToDecode) {
        String decode = CodecEnum.DECODE.toString();
        Codec codec = new Codec(textToDecode,decode);
        return codec.codec(textToDecode);
    }


}
