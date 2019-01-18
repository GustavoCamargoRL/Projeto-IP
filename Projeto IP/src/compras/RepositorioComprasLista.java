package compras;

public class RepositorioComprasLista 
implements RepositorioCompras{
	private Compra compras;
	private RepositorioComprasLista proximo;

	public RepositorioComprasLista() {
		this.compras = null;
		this.proximo = null;
	}

	public void cadastrar (Compra c) throws BilheteExistenteException{
		boolean i = this.existe(c.getId());
		if (i == true) {
			throw new BilheteExistenteException();
		} else {
			if (this.compras == null) {
				this.compras = c;
				this.proximo = new RepositorioComprasLista();
			} else {
				this.proximo.cadastrar(c);
			}
		}
	}

	public void atualizar (Compra c) throws CadastroNaoEncontradoException{

		if (this.compras.getId() == c.getId() ) {
			this.compras = c;
		} else if(this.proximo != null) {
			atualizar(c);
		} else {
			throw new CadastroNaoEncontradoException();

		}

	}

	public void remover (int id) throws CadastroNaoEncontradoException{
		if (this.compras != null) {
			if (this.compras.getId() == id) {
				this.compras = this.proximo.compras;
				this.proximo = this.proximo.proximo;
			} else {
				this.proximo.remover(id);
			}
		} else {
			throw new CadastroNaoEncontradoException(); 
		}
	}

	public Compra procurar (int id) throws CadastroNaoEncontradoException{
		Compra resposta = null;
		if (this.compras != null) {
			if (this.compras.getId() == id) {
				resposta = this.compras;
			} else {
				resposta = this.proximo.procurar(id);
			}
		} else {
			throw new CadastroNaoEncontradoException();
		}
		return resposta;
	}

	public boolean existe (int id) {
		if (this.compras != null) {
			if (this.compras.getId() == id) {
				return true;

			} else if (this.proximo != null){
				return this.proximo.existe(id);
			} else {
				return false;
			}
		} else {
		return false;
		}
	}

}
