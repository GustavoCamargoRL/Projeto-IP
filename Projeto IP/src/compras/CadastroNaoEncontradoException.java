package compras;

public class CadastroNaoEncontradoException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public CadastroNaoEncontradoException () {
		super ("Compra Nao Encontrada!");
	}

}
