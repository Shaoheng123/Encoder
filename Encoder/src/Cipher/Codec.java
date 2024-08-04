package Cipher;

public class Codec {

    private String referenceTable;
    private int firstChar;
    private String encode;

    public Codec(String textToEncode, String encode) {
        ApplicationProperties applicationProperties = new ApplicationProperties();
        this.referenceTable =  applicationProperties.getReferenceTable();
        this.encode = encode;

    }

    public String codec (String text){

        int index;

        int referenceTableLength = referenceTable.length();
        Character firstChar = getFirstChar(text);
        int offset = referenceTable.indexOf(firstChar);
        String removedOffsetCharacterText = text.substring(1);
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < removedOffsetCharacterText.length(); i++) {
            int indexOfElementInTable = referenceTable.indexOf(removedOffsetCharacterText.charAt(i));
            // if not found in reference table insert the element
            if(indexOfElementInTable == -1) {
                sb.insert(i, removedOffsetCharacterText.charAt(i));
                continue;
            }

            if(encode.equals(CodecEnum.ENCODE.toString())) {
                index = indexOfElementInTable - offset;
            } else{
                index = indexOfElementInTable + offset;
            }
            if( index < 0){
                index += referenceTableLength;
            }
            sb.insert(i, referenceTable.charAt((index) % referenceTableLength));
        }
        return sb.toString();
    }

    public Character getFirstChar(String plainText) {
        return plainText.charAt(0);
    }
}
