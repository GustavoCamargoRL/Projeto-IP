package salas;
import salas.SalaNaoEncontradaException;
import salas.SalaJaCriadaException;

public class CadastroSalas {
	private RepositorioSalas repositorioSala;
	
	
	public CadastroSalas(boolean repositorio) {			//seleciona o repositorio desejado
		if(repositorio) {
			this.repositorioSala = new RepositorioSalasLista();
		} else {
			this.repositorioSala = new RepositorioSalasArray();
		}
	}

	public void cadastrar(Sala sala) throws SalaJaCriadaException {			//verifica se a sala ja existe antes de inserir uma nova sala
		boolean igual = this.repositorioSala.existe(sala.getNumero());
		if (igual){										//caso exista uma sala igual, chama um erro
			throw new SalaJaCriadaException();
		} else {							//caso nao exista, insere a sala normalmente
			this.repositorioSala.inserir(sala);
		}
	}
	
	
	
	public void remover(int numero) throws SalaNaoEncontradaException{
		this.repositorioSala.remover(numero);
	}
	
	
	public Sala procurar (int numero) throws SalaNaoEncontradaException{
		return this.repositorioSala.procurar(numero);
	}
	
	
	public void atualizar (Sala salaAtt) throws SalaNaoEncontradaException{
		this.repositorioSala.atualizar(salaAtt);
	}
	
	public boolean existe (int numero) {
		return this.repositorioSala.existe(numero);
	}

	
	
	
	
}

