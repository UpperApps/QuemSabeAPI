package br.com.upperapps.services.exceptions;

public class ConhecimentoNaoEncontradoException extends RuntimeException {

	private static final long serialVersionUID = -446634430877128979L;

	public ConhecimentoNaoEncontradoException(String message, Throwable cause) {
		super(message, cause);
	}

	public ConhecimentoNaoEncontradoException(String message) {
		super(message);
	}
	
}
