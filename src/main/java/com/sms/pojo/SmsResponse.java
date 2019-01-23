package com.sms.pojo;

import java.util.List;

public class SmsResponse {

	private String ErrorCode;
	private String ErrorMessage;
	private String JobId;
	private List<ResponseMessage> MessageData;

	public String getErrorCode() {
		return ErrorCode;
	}

	public void setErrorCode(String errorCode) {
		ErrorCode = errorCode;
	}

	public String getErrorMessage() {
		return ErrorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		ErrorMessage = errorMessage;
	}

	public String getJobId() {
		return JobId;
	}

	public void setJobId(String jobId) {
		JobId = jobId;
	}

	public List<ResponseMessage> getMessageData() {
		return MessageData;
	}

	public void setMessageData(List<ResponseMessage> messageData) {
		MessageData = messageData;
	}

}
