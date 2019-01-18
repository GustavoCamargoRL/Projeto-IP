package salas;

public class RepositorioSalasLista implements RepositorioSalas{
	private Sala sala;
	private RepositorioSalasLista proximo;
	
	public RepositorioSalasLista(){
		this.sala = null;
		this.proximo = null;
		
	}
	
	public void inserir(Sala novaSala) {			//metodo inserir nova sala
		if(this.proximo == null) {					//checa se esta no final da lista e adiciona a sala
			this.sala = novaSala;
			this.proximo = new RepositorioSalasLista();
		} else {									//caso nao esteja no final da lista, chama a proxima sala
			this.proximo.inserir(novaSala);
		}
	}
	
	public void remover(int remover) throws SalaNaoEncontradaException{		//metodo remover sala, erro caso nao encontre a sala
		if(this.sala != null) {
			if(this.sala.getNumero() == remover) {								//checa se achou a sala e a remove da lista
				this.sala = this.proximo.sala;
				this.proximo = this.proximo.proximo;
			} else if (this.proximo != null) {									//continua procurando caso nao seja a sala desejada
				this.proximo.remover(remover);
			} else {															//ao chegar no final da lista e nao tenha encontrado a sala, throw erro
				throw new SalaNaoEncontradaException(); 
			}
		} else {
			throw new SalaNaoEncontradaException();
		}
	}
	
	public Sala procurar(int numero) throws SalaNaoEncontradaException {	//metodo procurar sala, erro caso nao encontre a sala
		if(this.sala.getNumero() == numero) {									//checa se achou a sala desejada e retorna ela
			return this.sala;
		} else if (this.proximo != null) {									//continua procurando caso nao seja a sala desejada
			return this.proximo.procurar(numero);
		} else {
			throw new SalaNaoEncontradaException();							//throw erro caso nao encontre a sala
		}
	}
	
	public void atualizar(Sala attSala) throws SalaNaoEncontradaException{	//metodo atualizar, erro caso nao encontre a sala
		if(this.sala.getNumero() == attSala.getNumero()) {						//checa se achou a sala desejada e atualiza seus atributos
			this.sala.setDisponiveis(attSala.getDisponiveis());
			this.sala.setVagas(attSala.getVagas());
			this.sala.setValor(attSala.getValor());
		} else if (this.proximo != null) {						//continua procurando caso nao seja a sala
			this.proximo.atualizar(attSala);
		} else {												//throw erro caso nao encontre a sala
			throw new SalaNaoEncontradaException();
		}
	}
	
	public boolean existe(int numero) {					//metodo existencia
		if(this.sala == null) {							//checa se é o ultimo elemento da lista
			return false;
		} else if (this.sala.getNumero() == numero) {	//checa se achou a sala e retorna true				
			return true;
		} else if(this.proximo != null){		//continua procurando a sala caso nao seja a sala desejada							
			return this.proximo.existe(numero);
		} else {									//retorna false se nao achar a sala
			return false;
		}
	}
}
