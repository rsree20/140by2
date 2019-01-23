package com.sms.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

import com.google.gson.Gson;
import com.sms.pojo.SmsRequest;
import com.sms.pojo.SmsResponse;
import com.sms.pojo.UserAccount;
import com.sms.pojo.UserMessages;

@Controller
public class Controller140 {

	@RequestMapping(value = "/sendSms")
	public String sendSms(Model model, @RequestParam("mobile") String mbl, @RequestParam("message") String msg) {

		System.out.println("Sending sms to : " + mbl);
		System.out.println("Message content is : " + msg);
		// hit sms gate api here

		RestTemplate restTemplate = new RestTemplate();
		String url = "https://www.smsgatewayhub.com/api/mt/SendSMS";

		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);

		SmsRequest smsBodyRequest = prepareRequestObject(mbl, msg);

		Gson gson = new Gson();
		String body = gson.toJson(smsBodyRequest);

		HttpEntity<String> entity = new HttpEntity<String>(body, headers);

		ResponseEntity<String> result = restTemplate.exchange(url, HttpMethod.POST, entity, String.class);
		String res = result.getBody();
		System.out.println("json format message : " + res);
		
		SmsResponse response = gson.fromJson(res, SmsResponse.class);

		System.out.println(response.getErrorCode());
		System.out.println(response.getErrorMessage());
		
		if(response.getErrorCode().equals("000")) {
			model.addAttribute("successMsg", "Your message sent successful!!");
		} else {
			model.addAttribute("errorMsg", response.getErrorMessage());			
		}
		// send response back to ui page
		return "Home";
	}

	private SmsRequest prepareRequestObject(String mbl, String msg) {
		SmsRequest smsBodyRequest = new SmsRequest();

		UserAccount account = new UserAccount();
		account.setUser("vemulas19");
		account.setPassword("srikanth7");
		account.setChannel("2");
		account.setDCS("0");
		account.setSenderId("SMSTST");

		List<UserMessages> messageList = new ArrayList<UserMessages>();
		UserMessages message = new UserMessages();
		message.setNumber(mbl);
		message.setText(msg);
		messageList.add(message);

		smsBodyRequest.setAccount(account);
		smsBodyRequest.setMessages(messageList);
		return smsBodyRequest;
	}

	public static void main(String[] args) {
		RestTemplate restTemplate = new RestTemplate();
		String url = "https://www.smsgatewayhub.com/api/mt/SendSMS";

		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);

		SmsRequest smsBody = new SmsRequest();

		UserAccount account = new UserAccount();
		account.setUser("vemulas19");
		account.setPassword("srikanth7");
		account.setChannel("2");
		account.setDCS("0");
		account.setSenderId("SMSTST");

		List<UserMessages> messageList = new ArrayList<UserMessages>();

		UserMessages message = new UserMessages();
		message.setNumber("9545772676");
		message.setText("Helo!! this is testing!!");
		messageList.add(message);

		smsBody.setAccount(account);
		smsBody.setMessages(messageList);

		Gson gson = new Gson();
		String body = gson.toJson(smsBody);

		HttpEntity<String> entity = new HttpEntity<String>(body, headers);

		ResponseEntity<String> result = restTemplate.exchange(url, HttpMethod.POST, entity, String.class);
		String res = result.getBody();
		System.out.println(res);

	}
}
