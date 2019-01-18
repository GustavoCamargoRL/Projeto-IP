package sessoes;


public class RepositorioSessoesLista implements RepositorioSessoes {
    private Sessao sessoes;
    private RepositorioSessoesLista proximo;

    public RepositorioSessoesLista() {
        this.sessoes = null;
        this.proximo =null;
    }

    public void inserir(Sessao sessao) {
        if (this.proximo == null) {
            this.sessoes = sessao;
            this.proximo = new RepositorioSessoesLista();
        } else {
            this.proximo.inserir(sessao);
        }
    }

    public void remover(int senha) throws SessaoNaoEncontradaException {
        if (senha == this.sessoes.getId()) {
            this.sessoes = this.proximo.sessoes;
            this.proximo = this.proximo.proximo;
        } else if (this.proximo != null){
            this.proximo.remover(senha);
        } else {
            throw new SessaoNaoEncontradaException();
        }

    }

    public void atualizar(Sessao sessao) throws SessaoNaoEncontradaException {
        if (sessao.getId() == this.sessoes.getId()) {
            this.sessoes = sessao;
        } else if (this.proximo != null) {
            this.proximo.atualizar(sessao);
        } else {
            throw new SessaoNaoEncontradaException();
        }
    }

    public Sessao procurar(int senha) throws SessaoNaoEncontradaException {
        Sessao se = null;
        if (senha == this.sessoes.getId()) {
            se = this.sessoes;
            return se;
        } else if (this.proximo != null){
            return this.proximo.procurar(senha);
        } else {
            throw new SessaoNaoEncontradaException();
        }

    }

    public boolean existe(int senha) {
        if (this.sessoes == null) {
            return false;
        } else if (senha == this.sessoes.getId()){
            return true;
        } else if(this.proximo != null) {
        	return this.proximo.existe(senha); 
        } else {
        	return false;
        }

    }

}
