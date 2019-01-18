package fachada;

public class FilmeOuSalaNaoExisteException extends Exception{
	private static final long serialVersionUID = 3L;

	public FilmeOuSalaNaoExisteException() {
		super("AVISO: Filme ou Sala nao existem, por favor verifique os dados");		//mensagem de erro ao nao encontrar uma sala ou filme na sessao
	}
}
