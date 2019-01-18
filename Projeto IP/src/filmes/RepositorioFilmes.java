package filmes;

public interface RepositorioFilmes {
	   void inserir(Filme novoFilme);
	   void remover(String nome) throws FilmeNaoEncontradoException;
	   Filme buscar(String nome) throws FilmeNaoEncontradoException;
	   boolean existe (String filme);
	   void atualizar(Filme filme) throws FilmeNaoEncontradoException;


}
