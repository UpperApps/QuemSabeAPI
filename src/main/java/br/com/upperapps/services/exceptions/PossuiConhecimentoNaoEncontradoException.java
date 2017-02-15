package br.com.upperapps.services.exceptions;

public class PossuiConhecimentoNaoEncontradoException extends RuntimeException {

	private static final long serialVersionUID = -446634430877128979L;

	public PossuiConhecimentoNaoEncontradoException(String message, Throwable cause) {
		super(message, cause);
	}

	public PossuiConhecimentoNaoEncontradoException(String message) {
		super(message);
	}
	
}
