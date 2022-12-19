package com.fastpay.sdkapi.utils;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.security.spec.AlgorithmParameterSpec;
import java.util.Base64;
import java.util.Random;

public class EncryptionHandler {

    private static final EncryptionHandler encryptionHandler = new EncryptionHandler();

    private EncryptionHandler() { }

    public static String getEncPassword(){
        return "G7RAi4BFastSolutionLkrjqTBoEYqCc";
    }
    
    public static String getEncWithPreifxPassword(){
        return "U2geM25MbSvltsfQwAsVg3rA1QVMnRXp";
    }

    public static EncryptionHandler getInstance() {
        return encryptionHandler;
    }
    
    private static String getIvString(int length) {
        String ivRandomChar = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz1234567890~!@#%^&*()_+";
        StringBuilder salt = new StringBuilder();
        Random rnd = new Random();
        while (salt.length() < length) {
            int index = (int) (rnd.nextFloat() * ivRandomChar.length());
            salt.append(ivRandomChar.charAt(index));
        }
        String saltStr = salt.toString();
        return saltStr;
    }

    /**
     * @param data Raw data which will need to encrypt
     * @return the final encrypted data with specific format
     */
    public static String encryptData(String data) {
        try {
            String ivValue = getIvString(16);
            byte[] ivBytes = ivValue.getBytes();
            byte[] keyBytes = getEncPassword().getBytes();
            byte[] textBytes = data.getBytes();
            AlgorithmParameterSpec ivSpec = new IvParameterSpec(ivBytes);
            SecretKeySpec newKey = new SecretKeySpec(keyBytes, "AES");
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            cipher.init(Cipher.ENCRYPT_MODE, newKey, ivSpec);
            String encData = Base64.getEncoder().encodeToString(cipher.doFinal(textBytes));           
            
            return Base64.getEncoder().encodeToString((ivValue + "||" + encData).getBytes());
        } catch (Exception e) {
        	
        	System.out.println(e.getMessage());
        	
            return null;
        }
    }
    
    /**
     * @param data Raw data which will need to encrypt with prefix
     * @return the final encrypted data with specific format
     */
    public static String encryptDataWithPrefix(String data) {
        try {
        	
        	data = "PayMe$." + data;
        	
            String ivValue = getIvString(16);
            byte[] ivBytes = ivValue.getBytes();
            byte[] keyBytes = getEncWithPreifxPassword().getBytes();
            byte[] textBytes = data.getBytes();
            AlgorithmParameterSpec ivSpec = new IvParameterSpec(ivBytes);
            SecretKeySpec newKey = new SecretKeySpec(keyBytes, "AES");
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            cipher.init(Cipher.ENCRYPT_MODE, newKey, ivSpec);
            String encData = Base64.getEncoder().encodeToString(cipher.doFinal(textBytes));           
            
            return Base64.getEncoder().encodeToString((ivValue + "||" + encData).getBytes());
        } catch (Exception e) {
        	
        	System.out.println(e.getMessage());
        	
            return null;
        }
    }

    /**
     * @param data Encrypted data
     * @return the decrypted data
     */
//    public String decryptData(String data) {
//        String[] parseResponseValue = new String(Base64.decode(data, Base64.DEFAULT)).split("\\|\\|");
//        try {
//            byte[] ivBytes = parseResponseValue[0].getBytes();
//            byte[] keyBytes = getEncPassword().getBytes();
//            byte[] textBytes = Base64.decode(parseResponseValue[1], Base64.DEFAULT);
//            AlgorithmParameterSpec ivSpec = new IvParameterSpec(ivBytes);
//            SecretKeySpec newKey = new SecretKeySpec(keyBytes, "AES/CBC/PKCS5Padding");
//            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
//            cipher.init(Cipher.DECRYPT_MODE, newKey, ivSpec);
//            return new String(cipher.doFinal(textBytes));
//        } catch (Exception e) {
//            return null;
//        }
//    }

    

}
