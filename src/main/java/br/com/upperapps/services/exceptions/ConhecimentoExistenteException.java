package br.com.upperapps.services.exceptions;

public class ConhecimentoExistenteException extends RuntimeException {

	private static final long serialVersionUID = -4779155983928995298L;

	public ConhecimentoExistenteException(String message, Throwable cause) {
		super(message, cause);
	}

	public ConhecimentoExistenteException(String message) {
		super(message);
	}
}
