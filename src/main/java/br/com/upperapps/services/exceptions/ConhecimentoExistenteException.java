package br.com.upperapps.services.exceptions;

public class ConhecimentoExistenteException extends RuntimeException {

	private static final long serialVersionUID = -5341460183535673659L;

	public ConhecimentoExistenteException(String mensagem) {
		super(mensagem);
	}

	public ConhecimentoExistenteException(String mensagem, Throwable causa) {
		super(mensagem, causa);
	}
}
