package br.com.upperapps.services.exceptions;

public class ProfissionalNaoEncontradoException extends RuntimeException{
	private static final long serialVersionUID = 1869300553614629711L;

	public ProfissionalNaoEncontradoException(String mensagem) {
		super(mensagem);
	}

	public ProfissionalNaoEncontradoException(String mensagem, Throwable causa) {
		super(mensagem, causa);
	}

}