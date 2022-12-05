package chat;

import java.nio.charset.StandardCharsets;
import java.security.spec.KeySpec;
import java.util.Base64;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author dhir4j
 */
public class EncryDecry {
    private static final String SALT = "ssshhhhhhhhhhh!!!!";

    // encrypt
public static String encrypt(String plainText, String secretKey)
        {
		try {

			// Create default byte array
			byte[] iv = { 0, 0, 0, 0, 0, 0, 0, 0,
						0, 0, 0, 0, 0, 0, 0, 0 };
			IvParameterSpec ivspec
				= new IvParameterSpec(iv);

			// Create SecretKeyFactory object
			SecretKeyFactory factory
				= SecretKeyFactory.getInstance(
					"PBKDF2WithHmacSHA256");
			
			// Create KeySpec object and assign with
			// constructor
			KeySpec spec = new PBEKeySpec(
				secretKey.toCharArray(), SALT.getBytes(),
				65536, 256);
			SecretKey tmp = factory.generateSecret(spec);
			SecretKeySpec secret_Key = new SecretKeySpec(
				tmp.getEncoded(), "AES");

			Cipher cipher = Cipher.getInstance(
				"AES/CBC/PKCS5Padding");
			cipher.init(Cipher.ENCRYPT_MODE, secret_Key,
						ivspec);
			// Return encrypted string
			return Base64.getEncoder().encodeToString(
				cipher.doFinal(plainText.getBytes(
					StandardCharsets.UTF_8)));
		}
		catch (Exception e) {
			System.out.println("Error while encrypting: "
							+ e.toString());
		}
		return null;
	}
   //decrypt
 	public static String decrypt(String cipherText, String secretKey)
	{
		try {

			// Default byte array
			byte[] iv = { 0, 0, 0, 0, 0, 0, 0, 0,
						0, 0, 0, 0, 0, 0, 0, 0 };
			// Create IvParameterSpec object and assign with
			// constructor
			IvParameterSpec ivspec
				= new IvParameterSpec(iv);

			// Create SecretKeyFactory Object
			SecretKeyFactory factory
				= SecretKeyFactory.getInstance(
					"PBKDF2WithHmacSHA256");

			// Create KeySpec object and assign with
			// constructor
			KeySpec spec = new PBEKeySpec(
				secretKey.toCharArray(), SALT.getBytes(),
				65536, 256);
			SecretKey tmp = factory.generateSecret(spec);
			SecretKeySpec secret_Key = new SecretKeySpec(
				tmp.getEncoded(), "AES");

			Cipher cipher = Cipher.getInstance(
				"AES/CBC/PKCS5PADDING");
			cipher.init(Cipher.DECRYPT_MODE, secret_Key,
						ivspec);
			// Return decrypted string
			return new String(cipher.doFinal(
				Base64.getDecoder().decode(cipherText)));
		}
		catch (Exception e) {
			System.out.println("Error while decrypting: "
							+ e.toString());
		}
		return null;
	}
}

   

 