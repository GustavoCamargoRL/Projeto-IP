package sessoes;

public interface RepositorioSessoes {
    public void inserir(Sessao sessao);
    public void remover(int senha) throws SessaoNaoEncontradaException;
    public void atualizar(Sessao sessao) throws SessaoNaoEncontradaException;
    public Sessao procurar(int senha) throws SessaoNaoEncontradaException;
    public boolean existe(int senha);
}
