package com.cg.ems.error;

import java.time.LocalDateTime;

public class ErrorInfo {
	LocalDateTime timestamp;
	String message;
	String uri;
	public ErrorInfo() {
		super();
	}
	public ErrorInfo(LocalDateTime timestamp, String message, String uri) {
		super();
		this.timestamp = timestamp;
		this.message = message;
		this.uri = uri;
	}
	public LocalDateTime getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(LocalDateTime timestamp) {
		this.timestamp = timestamp;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getUri() {
		return uri;
	}
	public void setUri(String uri) {
		this.uri = uri;
	}
	@Override
	public String toString() {
		return "ErrorInfo [timestamp=" + timestamp + ", message=" + message + ", uri=" + uri + "]";
	}

}
