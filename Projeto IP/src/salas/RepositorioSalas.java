package salas;

public interface RepositorioSalas {
	void inserir(Sala novaSala);
	void remover(int remover)
		throws SalaNaoEncontradaException;
	Sala procurar(int numero)
		throws SalaNaoEncontradaException;
	void atualizar(Sala attSala)
		throws SalaNaoEncontradaException;
	boolean existe(int numero);
}
