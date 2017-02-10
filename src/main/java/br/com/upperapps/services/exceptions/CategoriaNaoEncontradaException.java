package br.com.upperapps.services.exceptions;

public class CategoriaNaoEncontradaException extends RuntimeException{
	
	private static final long serialVersionUID = 1869300553614629712L;

	public CategoriaNaoEncontradaException(String mensagem) {
		super(mensagem);
	}

	public CategoriaNaoEncontradaException(String mensagem, Throwable causa) {
		super(mensagem, causa);
	}

}