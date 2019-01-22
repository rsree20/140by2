package com.sms.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class Controller140 {

	@RequestMapping(value="/sendSms")
	public String sendSms(@RequestParam("mobile") String mbl, @RequestParam("message") String msg) {
		
		System.out.println("Sending sms to : " + mbl);
		System.out.println("Message content is : " + msg);
		//hit sms gate api here
		
		//send response back to ui page
		return "Home";
	}
}
