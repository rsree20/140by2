package com.sms.controllers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Test {

	public static void main(String[] args) {
		String s = "9545772676;987896541;9898787852";
		String[] mobile = s.split(";");
		ArrayList<String> mobileList = new ArrayList<String>(Arrays.asList(mobile));
		for (String m : mobile) {
			if(mobileList.contains(m))
				mobileList.remove(m);
		}
		
		System.out.println(mobileList);
	}
}
