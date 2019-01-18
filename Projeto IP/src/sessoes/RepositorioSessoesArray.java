package sessoes;

public class RepositorioSessoesArray implements RepositorioSessoes {
    private Sessao[] sessoes;

    public RepositorioSessoesArray(int tam) {
        sessoes = new Sessao[tam];
    }

    public void inserir(Sessao sessao) {
    	boolean inseriu = false;
    	for(int i = 0; i < sessoes.length && !inseriu; i++) {
    		if(sessoes[i] == null) {
    			sessoes[i] = sessao;
    			inseriu = true;
    		}
    	}
    }

    public void remover(int senha) throws SessaoNaoEncontradaException {
        boolean achei = false;
        for(int i = 0; i < sessoes.length && !achei; i ++) {
            if (senha == sessoes[i].getId()) {
                achei = true;
                sessoes[i] = null;
                for (int j = i+1; j < sessoes.length && sessoes[j] != null; j++) {
                	sessoes[j-1] = sessoes[j];
                    if (sessoes[j+1] == null) {
                        sessoes[j] = null;
                    }
                }
            }
        }

        if (!achei) {
            throw new SessaoNaoEncontradaException();
        }

    }

    public void atualizar(Sessao sessao) throws SessaoNaoEncontradaException {
        boolean achei = false;
        for(int i = 0; i < sessoes.length && !achei && sessoes[i] != null; i++) {
            if (sessao.getId() == sessoes[i].getId()) {
                sessoes[i] = sessao;
                achei = true;
            } 
        }

        if (!achei) {
            throw new SessaoNaoEncontradaException();
        }
    }

    public Sessao procurar(int senha) throws SessaoNaoEncontradaException {
        Sessao se = null;
        for(int i = 0; i < sessoes.length && se == null; i ++) {
            if (senha == sessoes[i].getId()) {
                se = sessoes[i];
            }
        }

        if (se == null) {
            throw new SessaoNaoEncontradaException();
        } else {
        	return se;
        }
    }

    public boolean existe(int senha) {
        boolean existe = false;
        for(int i = 0; i < sessoes.length && sessoes[i] != null && !existe; i ++) {
            if (senha == sessoes[i].getId()) {
                existe = true;
            } 
        }
        if (existe) {
        	return existe;
        } else {
        	return false;
        }
    }

}

