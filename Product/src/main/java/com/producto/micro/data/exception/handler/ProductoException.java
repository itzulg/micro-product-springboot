package com.producto.micro.data.exception.handler;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.producto.micro.data.exceptions.BadRequestException;
import com.producto.micro.data.exceptions.NotFoundException;



@ControllerAdvice
	
public class ProductoException {
	
		@ExceptionHandler(value = BadRequestException.class)
		public ResponseEntity<Object> formatoInvalidoException(BadRequestException exception)
		{
			Map<String, Object> respuesta = new HashMap<String, Object>();
			respuesta.put("error", exception.getMessage());
			return new ResponseEntity<>(respuesta, HttpStatus.BAD_REQUEST);
		}
		
		@ExceptionHandler(value = NotFoundException.class)
		public ResponseEntity<?> noExisteException(NotFoundException exception)
		{
			Map<String, Object> respuesta = new HashMap<String, Object>();
			respuesta.put("error", exception.getMessage());
			return new ResponseEntity<>(respuesta, HttpStatus.NOT_FOUND);
		}
	
}
