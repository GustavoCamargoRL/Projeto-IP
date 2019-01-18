package filmes;

public class CadastroFilmes {
    private RepositorioFilmes repositorioFilmes;
   

    public CadastroFilmes(Boolean repositorio){
        if(repositorio){
            this.repositorioFilmes = new RepositorioFilmesLista();
            
        }else{
            this.repositorioFilmes = new RepositorioFilmesArray();
           
        }
    }

    public void cadastrar(Filme filme) throws FilmeCadastradoException {
        if(filme.getNome()!="" && !repositorioFilmes.existe(filme.getNome())){
            if(filme.getDuracao()>0){
            	repositorioFilmes.inserir(filme);
            }else{
                FilmeCadastradoException e;
                e = new FilmeCadastradoException();
                throw e;
            }
            
        }else{
            FilmeCadastradoException e;
            e = new FilmeCadastradoException();
            throw e;
        }
    }


    public void remover(String filme) throws FilmeNaoEncontradoException {
        if(repositorioFilmes.existe(filme)){
            repositorioFilmes.remover(filme);
        }else{
            throw new FilmeNaoEncontradoException();
        }
    }
    
	public Filme procurar (String nome) throws FilmeNaoEncontradoException{
		return this.repositorioFilmes.buscar(nome);
	}
	
	
	public void atualizar (Filme filme) throws FilmeNaoEncontradoException{
		this.repositorioFilmes.atualizar(filme);
	}
	
	public boolean existe (String filme) {
		return this.repositorioFilmes.existe(filme);
	}
    
    
    
    
}





