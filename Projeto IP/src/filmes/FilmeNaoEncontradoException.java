package filmes;

public class FilmeNaoEncontradoException extends Exception {
    private static final long serialVersionUID = 1L;

    public FilmeNaoEncontradoException() {
        super("Error. Filme nao encontrado para remocao.");
    }
} 