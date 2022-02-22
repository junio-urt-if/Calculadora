package br.com.ifurt.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

//usado de acordo com cada tipo de erro - de acordo com a tabela de código de erro
@ResponseStatus(HttpStatus.BAD_REQUEST)
public class UnsuportedMathOperationException extends RuntimeException{
	
	private static final long serialVersionUID = 1L;
	
	public UnsuportedMathOperationException(String exception) {
		super(exception);
	}

}
