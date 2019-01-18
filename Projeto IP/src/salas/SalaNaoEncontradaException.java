package salas;

public class SalaNaoEncontradaException extends Exception{
	private static final long serialVersionUID = 1L;
	
	public SalaNaoEncontradaException() {
		super("AVISO: Sala nao encontrada.");		//mensagem de erro ao nao encontrar uma sala
	}
	
	
}
