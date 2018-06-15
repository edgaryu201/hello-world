package com.zysoft.test;

import java.io.IOException;
import java.security.SecureRandom;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

public class DESHelper {
	 
    private byte[] desKey;
 
    public DESHelper(String desKey) {
        this.desKey = desKey.getBytes();
    }
 
    
    public byte[] desEncrypt(byte[] plainText) throws Exception {
        SecureRandom sr = new SecureRandom();
        byte rawKeyData[] = desKey;
        DESKeySpec dks = new DESKeySpec(rawKeyData);
        SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
        SecretKey key = keyFactory.generateSecret(dks);
        Cipher cipher = Cipher.getInstance("DES");
        cipher.init(Cipher.ENCRYPT_MODE, key, sr);
        byte data[] = plainText;
        byte encryptedData[] = cipher.doFinal(data);
        return encryptedData;
    }
 
    public byte[] desDecrypt(byte[] encryptText) throws Exception {
        SecureRandom sr = new SecureRandom();
        byte rawKeyData[] = desKey;
        DESKeySpec dks = new DESKeySpec(rawKeyData);
        SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
        SecretKey key = keyFactory.generateSecret(dks);
        Cipher cipher = Cipher.getInstance("DES");
        cipher.init(Cipher.DECRYPT_MODE, key, sr);
        byte encryptedData[] = encryptText;
        byte decryptedData[] = cipher.doFinal(encryptedData);
        return decryptedData;
    }
 
    public String encrypt(String input) throws Exception {
        return base64Encode(desEncrypt(input.getBytes()));
    }
 
    public String decrypt(String input) throws Exception {
        byte[] result = base64Decode(input);
        return new String(desDecrypt(result));
    }
 
    public static String base64Encode(byte[] s) {
        if (s == null)
            return null;
        BASE64Encoder b = new sun.misc.BASE64Encoder();
        return b.encode(s);
    }
 
    public static byte[] base64Decode(String s) throws IOException {
        if (s == null)
            return null;
        BASE64Decoder decoder = new BASE64Decoder();
        byte[] b = decoder.decodeBuffer(s);
        return b;
    }
    
    
    public static void test(){
    	
    	DESHelper des=new DESHelper("12345678");
    	try {
			String test=des.encrypt("邓美涛");
			System.out.println(test);
			
	//		String abc="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";
			String abc="E2ZKOMXwRVU=";
			String desc=des.decrypt(abc);
			System.out.println(desc);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
    	
    }
    public static void main(String[] args){
    	DESHelper des=new DESHelper("12345678");
    	try {
			String test=des.encrypt("邓美涛");
			System.out.println(test);
			
			String abc="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";
			String desc=des.decrypt(abc);
			System.out.println(new String(desc.getBytes(),"utf-8"));
			
		} catch (Exception e) {
			e.printStackTrace();
		}
    	
    }
     
}