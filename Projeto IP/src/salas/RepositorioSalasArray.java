package salas;


public class RepositorioSalasArray implements RepositorioSalas{
	private Sala[] array;
	private int tamanhoArray;

	public RepositorioSalasArray() {
		this.tamanhoArray = 2;							//tamanho inicial do array, podendo dobrar de tamanho caso necessario
		this.array = new Sala[tamanhoArray];
	}
	
	public void inserir(Sala novaSala) {				//metodo para inserir uma nova sala
		boolean inseriu = false;
		for(int i = 0; i < this.tamanhoArray && !inseriu; i++) {
			if(array[i] == null) {						//ao encontrar o primeiro elemento null do array, adiciona a sala indicada
				this.array[i] = novaSala;
				inseriu = true;
			} else if(i == this.tamanhoArray - 1) {		//caso o array esteja cheio, chama funcao para dobrar o tamanho do array
				dobraTamanho(array, novaSala, tamanhoArray);
			}
		}
		
	}
	
	public void dobraTamanho(Sala[] array, Sala novaSala, int n) {		//metodo para dobrar tamanho do array
		Sala[] aux = new Sala[n];							//cria um array auxiliar
		for(int i = 0; i < n; i++) {					
			aux[i] = array[i]; 								//salva todos os elementos do array no auxiliar
		}
		this.tamanhoArray = n*2;							//dobra tamanho
		this.array = new Sala[tamanhoArray];				//cria um novo array
		for(int i = 0; i < n; i++) {	
			this.array[i] = aux[i];							//passa todos os dados salvos para o novo array de tamanho dobrado
		}
		//inserir(novaSala);									//chama a funcao de inserir sala novamente
	}
	
	public void remover(int remover) throws SalaNaoEncontradaException{		//metodo para remover, chamando erro quando uma sala nao for encontrada
		boolean removeu = false;
		for(int i = 0; i < this.tamanhoArray && !removeu && this.array[i] != null; i++) {
			if(this.array[i].getNumero() == remover) {						//ao encontrar a sala, apaga ela do array
				this.array[i] = null;
				removeu = true;
				for (int j = i+1; j < this.tamanhoArray && this.array[j] != null; j++) {
                	this.array[j-1] = this.array[j];
                    if (this.array[j+1] == null) {
                        this.array[j] = null;
                    }
                }
			} 
		}
		if(!removeu) {
			throw new SalaNaoEncontradaException();						//caso nao ache a sala	
		}
	}
		
	public Sala procurar(int numero) throws SalaNaoEncontradaException{ 					//metodo para procurar uma sala
		Sala achou = null;
		for(int i = 0; i < this.tamanhoArray && achou == null; i++) {
			if(this.array[i].getNumero() == numero) {				//checa o numero da sala com a passada como parametro
				achou = this.array[i];							//retorna a sala
			}
		}
		if(achou == null) {										//se a sala nao for encontrada throw erro
			throw new SalaNaoEncontradaException();
		} else {												//se a sala for encontrada, retorna a sala
			return achou;
		}
		
	}
	
	public void atualizar(Sala attSala) throws SalaNaoEncontradaException{			//metodo para atualizar a sala
		boolean atualizou = false;
		for(int i = 0; i < this.tamanhoArray && !atualizou; i++) {
			if(this.array[i].getNumero() == attSala.getNumero()) {					//checa se e a sala desejada e atualiza seus atributos
				this.array[i].setDisponiveis(attSala.getDisponiveis());
				this.array[i].setVagas(attSala.getVagas());
				this.array[i].setValor(attSala.getValor());
				atualizou = true;
			}
		}
		if (!atualizou) {									//caso nao encontre a sala throw erro
			throw new SalaNaoEncontradaException();
		}
	}
	
	public boolean existe(int numero) {				//metodo para verificar existencia da sala
		boolean existencia = false;		//flag de existencia 
		for(int i = 0; i < this.tamanhoArray && !existencia && this.array[i] != null; i++) {
			if(this.array[i].getNumero() == numero) {
				existencia = true;
			}
		}
		
		if(existencia) {   				//caso exista retorna true
			return true;
		} else {						// caso nao exista retorna false
			return false;
		}
	}
}
