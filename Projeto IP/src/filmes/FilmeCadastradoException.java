package filmes;

public class FilmeCadastradoException extends Exception {
    private static final long serialVersionUID = 1L;
    
    public FilmeCadastradoException(){
        super("Filme não pode ser cadastrado");
    }

   
}