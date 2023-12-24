package com.fullstack.realestate.exception;

import org.springframework.http.HttpStatus;

public class MyException extends RuntimeException  {
    private static final long serialVersionUID = 4663380430591151564L;

	private HttpStatus httpStatus;
	private boolean success;

    public MyException(
            HttpStatus httpStatus,
			String message, boolean success) {
		super(message);
		this.httpStatus = httpStatus;
		this.success = success;
	}

	public int getHttpStatusCode() {
		return httpStatus.value();
	}
	
	public boolean getSuccess() {
		return success;
	}

    public String getHttpStatusType() {
        return httpStatus.getReasonPhrase();
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }
}