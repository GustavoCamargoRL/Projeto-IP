package compras;

public class BilheteExistenteException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public BilheteExistenteException () {
		super ("Bilhete Existente!");
	}

}