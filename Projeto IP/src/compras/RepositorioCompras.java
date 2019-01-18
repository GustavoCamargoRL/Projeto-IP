package compras;

public interface RepositorioCompras {
	
	public void cadastrar (Compra c)
			throws BilheteExistenteException;
	public void atualizar (Compra c)
			throws CadastroNaoEncontradoException;
	public void remover (int id) 
			throws CadastroNaoEncontradoException;
	public Compra procurar (int id)  
			throws CadastroNaoEncontradoException;
	public boolean existe (int id);
}
