package com.cpt.payments.utils;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

public class HmacSha256Utils {
	private HmacSha256Utils() {
		
	}
	/** give documetation 
	 * Generates an HMAC signature for a given JSON input using the provided secret key.
	 *
	 * @param secretKey The secret key used for HMAC computation.
	 * @param jsonInput The JSON input for which the HMAC signature is generated.
	 * @return The HMAC signature as a Base64-encoded string.
	 */

	public static String generateSignature(String secretKey, String jsonInput) {
		String hmacSignature = null;
		try {
			String algorithm = "HmacSHA256"; // You can choose a different algorithm if needed
			SecretKeySpec secretKeySpec = new SecretKeySpec(secretKey.getBytes(), algorithm);
			Mac mac = Mac.getInstance(algorithm);
			mac.init(secretKeySpec);
			byte[] hmacBytes = mac.doFinal(jsonInput.getBytes());
			hmacSignature = Base64.getEncoder().encodeToString(hmacBytes);
			System.out.println("HMAC Signature: " + hmacSignature);
		} catch (NoSuchAlgorithmException | InvalidKeyException e) {
			System.err.println("Error: " + e.getMessage());
		}
		return hmacSignature;

	}

}
