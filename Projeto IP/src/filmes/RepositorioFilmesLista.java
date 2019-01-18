package filmes;

public class RepositorioFilmesLista implements RepositorioFilmes{
    private Filme filme;
    private RepositorioFilmesLista proximo;

    void RepFilmeLista() {
        this.filme = null;
        this.proximo = null;

    }

public void inserir(Filme novoFilme){
        
            if (this.filme == null) {
                this.filme = novoFilme;
                this.proximo = new RepositorioFilmesLista();
             } else {
                this.proximo.inserir(novoFilme);
            }
        
}

public void remover(String nome) throws FilmeNaoEncontradoException{
    if(this.filme != null){
        if(this.filme.getNome().equals(nome)) {
            this.filme=this.proximo.filme;
            this.proximo=this.proximo.proximo;
        } else if(this.proximo != null){
            this.proximo.remover(nome);        
        } else {
        	throw new FilmeNaoEncontradoException();
        }
    } else {
    	throw new FilmeNaoEncontradoException();
    }

}

    public boolean buscar(Filme filmeBuscar) { // implementar busca
        if (this.filme.getNome().equals(filmeBuscar.getNome())) {
            return true;
        }else if(this.proximo != null){
            return this.proximo.buscar(filmeBuscar);
        }else{
            return false;
        }    
    }

	@Override
	public Filme buscar(String nome) throws FilmeNaoEncontradoException{
		 if (this.filme.getNome().equals(nome)) {
	            return this.filme;
	        }else if(this.proximo != null){
	            return this.proximo.buscar(nome);
	        }else{
	            throw new FilmeNaoEncontradoException();
	        } 
	}

	@Override
	public boolean existe(String filme) {
		if (this.filme == null) {
            return false;
        }else if(this.filme.getNome().equals(filme)){
            return true;
        }else if(this.proximo != null){
            return this.proximo.existe(filme);
        }else {
        	return false;
        }
	}

	@Override
	public void atualizar(Filme filme) throws FilmeNaoEncontradoException{
		if (this.filme.getNome().equals(filme.getNome())) {
            this.filme=filme;
        }else if(this.proximo != null){
            this.proximo.atualizar(filme);
        }else{
        	throw new FilmeNaoEncontradoException();
        }

	}



}


   
