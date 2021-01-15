package com.springmvc.email;

import org.springframework.stereotype.Component;

@Component
public class EmailDetails {

	private String sendersName;
	private String emailBody;
	private String emailSubject;
	
	public String getSendersName() {
		return sendersName;
	}
	public void setSendersName(String sendersName) {
		this.sendersName = sendersName;
	}
	public String getEmailBody() {
		return emailBody;
	}
	public void setEmailBody(String emailBody) {
		this.emailBody = emailBody;
	}
	public String getEmailSubject() {
		return emailSubject;
	}
	public void setEmailSubject(String emailSubject) {
		this.emailSubject = emailSubject;
	}
	public String getAttachmentFilePathList() {
		return attachmentFilePathList;
	}
	public void setAttachmentFilePathList(String attachmentFilePathList) {
		this.attachmentFilePathList = attachmentFilePathList;
	}
	public String getToList() {
		return toList;
	}
	public void setToList(String toList) {
		this.toList = toList;
	}
	public String getCcList() {
		return ccList;
	}
	public void setCcList(String ccList) {
		this.ccList = ccList;
	}
	public String getBccList() {
		return bccList;
	}
	public void setBccList(String bccList) {
		this.bccList = bccList;
	}
	private String attachmentFilePathList;
	private String toList;
	private String ccList;
	private String bccList;
	
	
}