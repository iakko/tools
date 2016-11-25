package net.iakko.tools.controllers.plain;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import net.iakko.tools.controllers.services.data.ErrorEntity;
import net.iakko.tools.controllers.services.exception.BaseException;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler
{
	@ExceptionHandler(value = BaseException.class)
	public ResponseEntity<Object> handleBaseException(BaseException e, WebRequest request)
	{
		//ErrorEntity error = new ErrorEntity();
		//error.setMessage(e.getMessage());
		//return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);

		ErrorEntity error = new ErrorEntity();
		error.setMessage("Error test :/");
		error.getFields().add("Field 1");
		error.getFields().add("Field 2");
		error.getFields().add("Field 3");

		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);

		return handleExceptionInternal(e, error, headers, HttpStatus.INTERNAL_SERVER_ERROR, request);
	}

	@ExceptionHandler(value = Exception.class)
	public ResponseEntity<String> handleException(Exception e)
	{
		return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
