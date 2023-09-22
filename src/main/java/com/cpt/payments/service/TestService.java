package com.cpt.payments.service;

import com.cpt.payments.pojo.AddRequest;
import com.cpt.payments.utils.HmacSha256Utils;
import com.google.gson.Gson;

public class TestService {
	private String secretKey = "ecom-ct-secret123";

	public int validateAndProcess(AddRequest req, String clientSignature) {
		// here we get request Bode but we have to convert into Json

		Gson gson = new Gson();
		String jsonRequest = gson.toJson(req);

		String generateSignature = HmacSha256Utils.generateSignature(secretKey, jsonRequest);
		System.out.println("inputString :" + jsonRequest);
		System.out.println("generateSignature :" + generateSignature);

		if (generateSignature.equals(clientSignature)) {
//			process logic
			return req.getNum1()+req.getNum2();
		}
		return -1;

	}

}
