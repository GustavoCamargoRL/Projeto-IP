package fachada;

public class SalaLotadaException extends Exception{
	private static final long serialVersionUID = 5L;
	
	public SalaLotadaException() {
		super("AVISO: Sala lotada, por favor escolha outra sessao");		//mensagem de erro em compra indisponivel
	}
}

