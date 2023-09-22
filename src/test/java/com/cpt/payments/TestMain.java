package com.cpt.payments;

import com.cpt.payments.pojo.AddRequest;
import com.google.gson.Gson;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public class TestMain {

	/*
	 * public static void main(String[] args) { Gson gson = new Gson();
	 * 
	 * AddRequest request = new AddRequest(); request.setNum1(3);
	 * request.setNum2(4);
	 * 
	 * System.out.println(gson.toJson(request)); }
	 */

//	public static void main(String[] args) {
//		String jsonInput = "{\"key1\":\"value1\",\"key2\":\"value2\"}";
//		String secretKey = "ecom-ct-secret123";
//
//		try {
//			String hmacSignature = generateHmac(jsonInput, secretKey);
//			System.out.println("HMAC Signature: " + hmacSignature);
//			
//			
//		} catch (Exception e) {
//			System.err.println("Error: " + e.getMessage());
//		}
//	}
//
//	public static String generateHmac(String data, String secretKey)
//			throws NoSuchAlgorithmException, InvalidKeyException {
//		String algorithm = "HmacSHA256"; // You can choose a different algorithm if needed
//		SecretKeySpec secretKeySpec = new SecretKeySpec(secretKey.getBytes(), algorithm);
//		Mac mac = Mac.getInstance(algorithm);
//		mac.init(secretKeySpec);
//		byte[] hmacBytes = mac.doFinal(data.getBytes());
//		return Base64.getEncoder().encodeToString(hmacBytes);
//	}

	public static void main(String[] args) {
		String jsonInput = "{\"key1\":\"value1\",\"key2\":\"value2\"}";
		String secretKey = "ecom-ct-secret123";

		try {
			String algorithm = "HmacSHA256"; // You can choose a different algorithm if needed
			SecretKeySpec secretKeySpec = new SecretKeySpec(secretKey.getBytes(), algorithm);
			Mac mac = Mac.getInstance(algorithm);
			mac.init(secretKeySpec);
			byte[] hmacBytes = mac.doFinal(jsonInput.getBytes());
			String hmacSignature = Base64.getEncoder().encodeToString(hmacBytes);
			System.out.println("HMAC Signature: " + hmacSignature);
		} catch (NoSuchAlgorithmException | InvalidKeyException e) {
			System.err.println("Error: " + e.getMessage());
		}
	}
}
