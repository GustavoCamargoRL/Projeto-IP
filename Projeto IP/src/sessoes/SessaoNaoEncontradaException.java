package sessoes;

public class SessaoNaoEncontradaException extends Exception {

    public SessaoNaoEncontradaException() {
        super("Esta sessão não foi encontrada.");
    }
}

