package br.com.upperapps.services.exceptions;

public class ProfissionalExistenteException extends RuntimeException{
	private static final long serialVersionUID = 1869300553614629711L;

	public ProfissionalExistenteException(String mensagem) {
		super(mensagem);
	}

	public ProfissionalExistenteException(String mensagem, Throwable causa) {
		super(mensagem, causa);
	}

}