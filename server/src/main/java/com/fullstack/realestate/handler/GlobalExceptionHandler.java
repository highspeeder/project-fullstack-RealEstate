package com.fullstack.realestate.handler;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

import com.fullstack.realestate.exception.MyException;

@ControllerAdvice
@RestController
public class GlobalExceptionHandler {
	@ExceptionHandler(value = Exception.class)
	public ResponseEntity<String> handleArgumentException(Exception e) {
		return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@ExceptionHandler(value = MyException.class)
    public ResponseEntity<Map<String, Object>> ExceptionHandler(MyException e) {
		HttpHeaders responHeaders = new HttpHeaders();
		
		Map<String, Object> map = new HashMap<>();
		map.put("success", e.getSuccess());
        map.put("error type", e.getHttpStatusType());
        map.put("code", e.getHttpStatusCode());
        map.put("message", e.getMessage());

        return new ResponseEntity<>(map, responHeaders, e.getHttpStatus());
    }
}
