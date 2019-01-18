package sessoes;

public class SessaoJaCadastradaException extends Exception {
    public SessaoJaCadastradaException() {
        super("Esta sessão já foi cadastrada");
    }

}

