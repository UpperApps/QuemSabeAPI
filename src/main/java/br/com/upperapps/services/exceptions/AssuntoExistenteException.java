package br.com.upperapps.services.exceptions;

public class AssuntoExistenteException extends RuntimeException {

	private static final long serialVersionUID = -5341460183535673659L;

	public AssuntoExistenteException(String mensagem) {
		super(mensagem);
	}

	public AssuntoExistenteException(String mensagem, Throwable causa) {
		super(mensagem, causa);
	}
}
