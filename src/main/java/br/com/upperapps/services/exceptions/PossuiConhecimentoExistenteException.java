package br.com.upperapps.services.exceptions;

public class PossuiConhecimentoExistenteException extends RuntimeException {

	private static final long serialVersionUID = -4779155983928995298L;

	public PossuiConhecimentoExistenteException(String message, Throwable cause) {
		super(message, cause);
	}

	public PossuiConhecimentoExistenteException(String message) {
		super(message);
	}
}
