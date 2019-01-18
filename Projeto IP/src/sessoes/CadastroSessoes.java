package sessoes;

public class CadastroSessoes {

    private RepositorioSessoes repositorioSessoes;

    public CadastroSessoes(boolean lista) {
        if(lista){
            this.repositorioSessoes = new RepositorioSessoesLista();
        }else{
            this.repositorioSessoes = new RepositorioSessoesArray(30);
        }
    }

    public void cadastrar(Sessao sessao) throws SessaoJaCadastradaException {
        if (!repositorioSessoes.existe(sessao.getId())) {
            repositorioSessoes.inserir(sessao);
        } else {
            throw new SessaoJaCadastradaException();
        }
    }

    public void remover(int idSessao) throws SessaoNaoEncontradaException {
        if (repositorioSessoes.existe(idSessao)) {
            repositorioSessoes.remover(idSessao);
        } else {
            throw new SessaoNaoEncontradaException();
        }
    }

    public Sessao procurar(int idSessao) throws SessaoNaoEncontradaException {
        Sessao se = null;
        if (repositorioSessoes.existe(idSessao)) {
            se = repositorioSessoes.procurar(idSessao);
            return se;
        } else {
            throw new SessaoNaoEncontradaException();
        }
    }

    public void atualizar(Sessao sessao) throws SessaoNaoEncontradaException {
        if (repositorioSessoes.existe(sessao.getId())) {
            repositorioSessoes.atualizar(sessao);
        } else {
            throw new SessaoNaoEncontradaException();
        }
    }

    public boolean existe(int idSessao) {
        return repositorioSessoes.existe(idSessao);
    }

}