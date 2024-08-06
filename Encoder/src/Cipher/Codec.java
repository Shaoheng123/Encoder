package Cipher;

public class Codec {

    private String referenceTable;
    private String encodeOrDecode;
    private String text;

    public Codec(String text, String encodeOrDecode) {
        ApplicationProperties applicationProperties = new ApplicationProperties();
        this.referenceTable =  applicationProperties.getReferenceTable();
        this.encodeOrDecode = encodeOrDecode;
        this.text=text;

    }

    public String codec (){

        int newIndex;
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
            if(encodeOrDecode.equals(CodecEnum.ENCODE.toString())) {
                newIndex = indexOfElementInTable - offset;
            } else{
                newIndex = indexOfElementInTable + offset;
            }
            if( newIndex < 0){
                newIndex += referenceTableLength;
            }
            //insert character 
            sb.insert(i, referenceTable.charAt((newIndex) % referenceTableLength));
        }
        return sb.toString();
    }

    public Character getFirstChar(String plainText) {
        return plainText.charAt(0);
    }
}
