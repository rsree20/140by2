package com.sms.pojo;

public class UserAccount {

	private String User;
	private String SenderId;
	private String GroupId;
	private String Channel;
	private String Password;
	private String DCS;
	private String SchedTime;

	public String getUser() {
		return User;
	}

	public void setUser(String user) {
		User = user;
	}

	public String getSenderId() {
		return SenderId;
	}

	public void setSenderId(String senderId) {
		SenderId = senderId;
	}

	public String getGroupId() {
		return GroupId;
	}

	public void setGroupId(String groupId) {
		GroupId = groupId;
	}

	public String getChannel() {
		return Channel;
	}

	public void setChannel(String channel) {
		Channel = channel;
	}

	public String getPassword() {
		return Password;
	}

	public void setPassword(String password) {
		Password = password;
	}

	public String getDCS() {
		return DCS;
	}

	public void setDCS(String dCS) {
		DCS = dCS;
	}

	public String getSchedTime() {
		return SchedTime;
	}

	public void setSchedTime(String schedTime) {
		SchedTime = schedTime;
	}

}
