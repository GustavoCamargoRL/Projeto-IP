package filmes;

public class FilmeCadastradoException extends Exception {
    private static final long serialVersionUID = 1L;
    
    public FilmeCadastradoException(){
        super("Filme n�o pode ser cadastrado");
    }

   
}