package br.com.upperapps.services.exceptions;

public class PessoalNaoEncontradoException extends RuntimeException{
	private static final long serialVersionUID = 1869300553614629711L;

	public PessoalNaoEncontradoException(String mensagem) {
		super(mensagem);
	}

	public PessoalNaoEncontradoException(String mensagem, Throwable causa) {
		super(mensagem, causa);
	}

}