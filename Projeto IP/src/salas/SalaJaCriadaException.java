package salas;

public class SalaJaCriadaException extends Exception{
	private static final long serialVersionUID = 2L;
		
	public SalaJaCriadaException() {
		super("AVISO: A sala inserida ja existe.");		//mensagem de erro ao inserir uma sala ja existente
	}
		
		
}
