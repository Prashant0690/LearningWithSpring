package org.pt.learning.rest.response;

import org.pt.learning.enums.ResponseStatus;


public class GenericResponseBuilder {
	
	public static <E>  ResponseWrapper<E> successResponse(E e){
		ResponseWrapper<E> response = new ResponseWrapper<E>();
		response.setStatus(ResponseStatus.Success);
		response.setResponse(e);
		return response;
	}
	
	public static <E>  ResponseWrapper<E> failureResponse(E e){
		ResponseWrapper<E> response = new ResponseWrapper<E>();
		response.setStatus(ResponseStatus.Error);
		response.setResponse(e);
		return response;
	}

}
