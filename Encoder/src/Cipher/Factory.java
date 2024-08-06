package Cipher;

interface Factory {
    Cipher createCipher(String plainOrEncoded, String toEncode);
}