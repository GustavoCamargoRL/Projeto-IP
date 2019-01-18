package fachada;

public class SessaoErrorException extends Exception{
	private static final long serialVersionUID = 4L;

	public SessaoErrorException() {
		super("AVISO: Sessao inexistente, por favor escolha outra sessao");		//mensagem de erro em sessao inexistente
	}
}
