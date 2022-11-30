package chat;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author admin
 */
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
/**
 *
 * @author user
 */
public class EncryDecry {
    public static final String alpha = "abcdefghijklmnopqrstuvwxyz";

    // encrypt
        public String encrypt(String plainText, int shiftKey) {
        try {
            plainText = plainText.toLowerCase();
            plainText = plainText.replaceAll(" ", "");
            String cipherText = "";
            for (int i = 0; i < plainText.length(); i++) {
                int charPosition = alpha.indexOf(plainText.charAt(i));
                int keyVal = (shiftKey + charPosition) % 26;
                char replaceVal = alpha.charAt(keyVal);
                cipherText += replaceVal;
            }
            return cipherText;
        } catch (Exception e) {
            System.out.println("Error encrypting: " + e.toString());
        }
        return null;
    }
   //decrypt
    public String decrypt(String cipherText, int shiftKey) {
        try {
            cipherText = cipherText.toLowerCase();
            String plainText = "";
            for (int ii = 0; ii < cipherText.length(); ii++) {
                int charPosition = alpha.indexOf(cipherText.charAt(ii));
                int keyVal = (charPosition - shiftKey) % 26;
                if (keyVal < 0) {
                keyVal = alpha.length() + keyVal;
            }
          char replaceVal = alpha.charAt(keyVal);
          plainText += replaceVal;
        }
        return plainText;
        } catch (Exception e) {
            System.out.println("Error decrypting: " + e.toString());
        }
        return null;
    }
   

   
}