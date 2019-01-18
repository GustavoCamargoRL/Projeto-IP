package fachada;

import compras.CadastroCompras;
import compras.Compra;
import filmes.CadastroFilmes;
import filmes.Filme;
import salas.CadastroSalas;
import salas.Sala;
import salas.SalaNaoEncontradaException;
import sessoes.CadastroSessoes;
import sessoes.Sessao;
import filmes.FilmeNaoEncontradoException;
import sessoes.SessaoNaoEncontradaException;
import compras.CadastroNaoEncontradoException;
import salas.SalaJaCriadaException;
import filmes.FilmeCadastradoException;
import compras.BilheteExistenteException;
import sessoes.SessaoJaCadastradaException;


public class Cinema {
	private CadastroSalas salas;
	private CadastroFilmes filmes;
	private CadastroSessoes sessoes;
	private CadastroCompras compras;
	//private CadastroFuncionarios funcionarios;

	public Cinema(boolean lista) {
		this.salas = new CadastroSalas(lista);
		this.filmes = new CadastroFilmes(lista);
		this.sessoes = new CadastroSessoes(lista);
		this.compras = new CadastroCompras(lista);
		//this.funcionarios = new CadastroFuncionarios(lista);

	}

	public void cadastrarSessao(Sessao novaSessao) throws FilmeOuSalaNaoExisteException, SessaoJaCadastradaException { // checagem para inserir nova sessao
		boolean FilmeValido = this.filmes.existe(novaSessao.getFilme().getNome()); // checa se o filme existe
		boolean SalaValida = this.salas.existe(novaSessao.getSala().getNumero()); // checa se a sala existe

		if (FilmeValido && SalaValida) { // caso o filme e a sala exista, insere nova sessao
			this.sessoes.cadastrar(novaSessao);
		} else {
			throw new FilmeOuSalaNaoExisteException();
		}

	}

	public void cadastrarCompra(Compra novaCompra) throws SessaoErrorException, SalaLotadaException, SalaNaoEncontradaException, BilheteExistenteException{	//checagem para nova compra
			boolean SessaoValida = this.sessoes.existe(novaCompra.getSessao().getId());							//checa se a sessao existe
			boolean SalaLotada = (novaCompra.getSessao().getSala().getDisponiveis() == 0);									//checa se a sala esta lotada
			if(SessaoValida){					//caso sessao exista
				if(!SalaLotada) {				//caso sala nao esteja lotada
					this.compras.cadastrar(novaCompra);				//registra nova compra
					novaCompra.getSessao().getSala().setDisponiveis(novaCompra.getSessao().getSala().getDisponiveis() - 1);
					this.salas.atualizar(novaCompra.getSessao().getSala());		//atualiza quantidade de vagas disponiveis na sala
				} else {
					throw new SalaLotadaException();
				}
			} else {
				throw new SessaoErrorException();
			}					
		}

	public void cadastrarFilme(Filme novo) throws FilmeCadastradoException{ // insere novo Filme
		this.filmes.cadastrar(novo);
	}

	public void cadastrarSala(Sala nova) throws SalaJaCriadaException{ // insere nova sala
		this.salas.cadastrar(nova);
	}
	
	////////metodos existe////////////////
	
	public boolean existeSala(int numero) {
		return this.salas.existe(numero);
	}
	
	public boolean existeFilme(String nome) {
		return this.filmes.existe(nome);
	}
	
	public boolean existeSessao(int id) {
		return this.sessoes.existe(id);
	}
	
	public boolean existeCompra(int id) {
		return this.compras.existe(id);
	}
	
	//////////metodos atualizar////////////////
	
	public void atualizarSala(Sala salaAtt) throws SalaNaoEncontradaException{
		this.salas.atualizar(salaAtt);
	}
	
	public void atualizarFilme(Filme filmeAtt) throws FilmeNaoEncontradoException{
		this.filmes.atualizar(filmeAtt);
	}
	
	public void atualizarSessao(Sessao sessaoAtt) throws SessaoNaoEncontradaException{
		this.sessoes.atualizar(sessaoAtt);
	}
	
	public void atualizarCompra(Compra compraAtt) throws CadastroNaoEncontradoException{
		this.compras.atualizar(compraAtt);
	}
	
	//////////////metodos remover//////////////
	
	public void removerSala(int numero) throws SalaNaoEncontradaException{
		this.salas.remover(numero);
	}
	
	public void removerFilme(String nome) throws FilmeNaoEncontradoException{
		this.filmes.remover(nome);
	}
	
	public void removerSessao(int id) throws SessaoNaoEncontradaException{
		this.sessoes.remover(id);
	}
	
	public void removerCompra(int id) throws CadastroNaoEncontradoException{
		this.compras.remover(id);
	}

	///////////metodos buscar/////////////////
	
	public Filme procurarFilme(String nome) throws FilmeNaoEncontradoException{
		return this.filmes.procurar(nome);
	}
	
	public Sala procurarSala(int numero) throws SalaNaoEncontradaException{
		return this.salas.procurar(numero);
	}
	
	public Sessao procurarSessao(int id) throws SessaoNaoEncontradaException{
		return this.sessoes.procurar(id);
	}
	
	public Compra procurarCompra(int id) throws CadastroNaoEncontradoException{
		return this.compras.procurar(id);
	}


}

