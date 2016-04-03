package org.pt.learning.rest.response;

import org.pt.learning.enums.ResponseStatus;

public class ResponseWrapper<T> {
	
	private ResponseStatus status;
	
	private T response;

	public ResponseStatus getStatus() {
		return status;
	}

	public void setStatus(ResponseStatus status) {
		this.status = status;
	}

	public T getResponse() {
		return response;
	}

	public void setResponse(T response) {
		this.response = response;
	}
	
}
