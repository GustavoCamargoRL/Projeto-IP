package compras;

import compras.RepositorioCompras;
import compras.RepositorioComprasArray;
import compras.RepositorioComprasLista;

public class CadastroCompras {
	
	private RepositorioCompras repCompra;
	
	
	public CadastroCompras(boolean escolha) {
		if(escolha == true) {
			repCompra = new RepositorioComprasLista();
		} else {
			repCompra = new RepositorioComprasArray(5);
		}
	}
	
	public void cadastrar(Compra c) throws BilheteExistenteException{
		repCompra.cadastrar(c);
	}
	
	public void atualizar(Compra c) throws CadastroNaoEncontradoException {
		repCompra.atualizar(c);
	}
	
	public void remover(int id) throws CadastroNaoEncontradoException {
		repCompra.remover(id);
	}
	
	public Compra procurar (int id) throws CadastroNaoEncontradoException {
		return repCompra.procurar(id);
	}
	
	public boolean existe (int id) {
		return repCompra.existe(id);
	}

}