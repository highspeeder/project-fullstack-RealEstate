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
	// @ExceptionHandler(value = Exception.class)
	// public ResponseEntity<String> handleArgumentException(Exception e) {
	// 	return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
	// }

	//시스템 예외
	@ExceptionHandler(value = Exception.class)
	public ResponseEntity<Map<String, Object>> ExceptionHandler(Exception e) {
		HttpHeaders responHeaders = new HttpHeaders();

		MyException myException = new MyException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage(), false);

		Map<String, Object> map = new HashMap<>();
		map.put("success", myException.getSuccess());
		map.put("error type", myException.getHttpStatusType());
		map.put("code", myException.getHttpStatusCode());
		map.put("message", myException.getMessage());

		return new ResponseEntity<>(map, responHeaders, myException.getHttpStatusCode());
	}

	//사용자 정의 예외
	@ExceptionHandler(value = MyException.class)
	public ResponseEntity<Map<String, Object>> MyExceptionHandler(MyException e) {
		HttpHeaders responHeaders = new HttpHeaders();

		Map<String, Object> map = new HashMap<>();
		map.put("success", e.getSuccess());
		map.put("error type", e.getHttpStatusType());
		map.put("code", e.getHttpStatusCode());
		map.put("message", e.getMessage());

		return new ResponseEntity<>(map, responHeaders, e.getHttpStatusCode());
	}
}
