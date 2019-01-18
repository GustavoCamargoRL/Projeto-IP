package filmes;

public class RepositorioFilmesArray implements RepositorioFilmes{
    private int posicao;
    private int n;
    private Filme[] arrayFilmes;
    
    RepositorioFilmesArray(){
        this.n=100;
        arrayFilmes = new Filme[this.n];
    }
    
       

    public void inserir(Filme newFilme){
        if(this.posicao<=n-1){
            arrayFilmes[this.posicao]=newFilme;
            this.posicao++;
        }
    }

    public void remover(String nome){
        int i=0;
        boolean controle=true;
        boolean naoAchou=true;

        while(controle && naoAchou){
            if(controle && i==this.n){
                naoAchou=false;
            }else if(!arrayFilmes[i].getNome().equals(nome)){
                i++;
            }else{
                controle=false;
            }
        }

        if(!controle && naoAchou){
            for(;i<n && arrayFilmes[i]!=null;i++){
                if(i==n-1){
                    arrayFilmes[i]=arrayFilmes[i];
                }else{
                    arrayFilmes[i]=arrayFilmes[i+1];
                }
                
            }
            this.posicao--;
        }

    }

    public boolean existe(String filme){
        int i=0;
        boolean achou=false;
        for(; i<n && arrayFilmes[i]!=null && !achou; i++){
            if(arrayFilmes[i].getNome().equals(filme)) 
                achou=true;
        }
        return achou;
    }

   public Filme buscar(String nome) throws FilmeNaoEncontradoException{
       boolean achou=false;
       Filme f=null;
        for(int i=0; i<n && arrayFilmes[i]!=null; i++){
            if(arrayFilmes[i].getNome().equals(nome)) { 
                achou=true;
               f = this.arrayFilmes[i];
                
            }
        }
        
        	
        if(!achou) {
        	throw new FilmeNaoEncontradoException();
        }
        	return f;
       
        
    }
    public void atualizar(Filme filme)throws FilmeNaoEncontradoException{
        boolean controle = false;
        for(int i=0; i<n && arrayFilmes[i]!=null && !controle; i++){
            if(arrayFilmes[i].getNome().equals(filme.getNome())){
                arrayFilmes[i]=filme;
                controle=true;
            }
        }
        if(!controle) {
        	throw new FilmeNaoEncontradoException();
        }
        
    }



    
}


  