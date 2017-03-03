package br.com.upperapps.services.exceptions;

public class PessoaExistenteException extends RuntimeException{
	private static final long serialVersionUID = 1869300553614629711L;

	public PessoaExistenteException(String mensagem) {
		super(mensagem);
	}

	public PessoaExistenteException(String mensagem, Throwable causa) {
		super(mensagem, causa);
	}

}