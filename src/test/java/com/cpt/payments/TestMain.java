package com.cpt.payments;

import com.cpt.payments.pojo.AddRequest;
import com.google.gson.Gson;

public class TestMain {

	public static void main(String[] args) {
		Gson gson = new Gson();

		AddRequest request = new AddRequest();
		request.setNum1(3);
		request.setNum2(4);

		System.out.println(gson.toJson(request));
	}
}
