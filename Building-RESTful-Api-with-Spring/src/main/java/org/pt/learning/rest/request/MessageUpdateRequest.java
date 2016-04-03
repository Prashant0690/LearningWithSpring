package org.pt.learning.rest.request;

import javax.validation.constraints.NotNull;

public class MessageUpdateRequest {
	
	@NotNull
	private Long MessageId;
	
	@NotNull
	private String message;

	public Long getMessageId() {
		return MessageId;
	}

	public void setMessageId(Long messageId) {
		MessageId = messageId;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
}
