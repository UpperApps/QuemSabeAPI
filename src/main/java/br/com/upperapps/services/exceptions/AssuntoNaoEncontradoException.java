package br.com.upperapps.services.exceptions;

public class AssuntoNaoEncontradoException extends RuntimeException {

	private static final long serialVersionUID = 6744092985949891213L;
	
	public AssuntoNaoEncontradoException(String mensagem) {
		super(mensagem);
	}

	public AssuntoNaoEncontradoException(String mensagem, Throwable causa) {
		super(mensagem, causa);
	}
	
}
