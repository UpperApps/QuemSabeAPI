package br.com.upperapps.services.exceptions;

public class ConhecimentoNaoEncontradoException extends RuntimeException {

	private static final long serialVersionUID = 6744092985949891213L;
	
	public ConhecimentoNaoEncontradoException(String mensagem) {
		super(mensagem);
	}

	public ConhecimentoNaoEncontradoException(String mensagem, Throwable causa) {
		super(mensagem, causa);
	}
	
}
