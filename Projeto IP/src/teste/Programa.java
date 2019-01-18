package teste;

import compras.Compra;
import fachada.Cinema;
import filmes.Filme;
import salas.Sala3D;
import salas.SalaNormal;
import salas.SalaSuper;
import sessoes.Sessao;
import filmes.FilmeCadastradoException;
import salas.SalaJaCriadaException;
import sessoes.SessaoJaCadastradaException;
import compras.BilheteExistenteException;
import fachada.FilmeOuSalaNaoExisteException;
import fachada.SalaLotadaException;
import fachada.SessaoErrorException;
import salas.SalaNaoEncontradaException;
import filmes.FilmeNaoEncontradoException;
import sessoes.SessaoNaoEncontradaException;
import compras.CadastroNaoEncontradoException;

public class Programa {
	
	public static void main(String[] args) {
		
/////////////////////////// INICIALIZAÇAO DAS CLASSES ////////////////////////////////////////////////////////////
		
		Filme filme1 = new Filme("Star Wars 1", "Ficcao",14,120);
		Filme filme2 = new Filme("Titanic", "Romance",0,100);
		Filme filme3 = new Filme("Senhor dos Aneis: A sociedade do anel","Fantasia",10,180);
		Filme filme5 = new Filme("Frozen", "Animaçao", 14, 240);
		SalaNormal sala1 = new SalaNormal(1,40,40);
		sala1.debitar();
		SalaSuper sala2 = new SalaSuper(2,60,60);
		sala2.debitar();
		Sala3D sala3 = new Sala3D(3,50,50);
		sala3.debitar();
		Sessao sessao1 = new Sessao(filme1,sala2,"20:00",1);
		Sessao sessao2 = new Sessao(filme2,sala1,"14:00",2);
		Sessao sessao3 = new Sessao(filme3,sala3,"19:00",3);
		Compra compra1 = new Compra(sessao1,true,1);
		Compra compra2 = new Compra(sessao2,false,2);
		Compra compra3 = new Compra(sessao3,true,3);
///////////////////////////////////////////////////////////////////////////////////////////////////////////////
		
		
		Cinema uci = new Cinema(true); //inicializa a fachada
		
//////////////////////////////// CADASTRAMENTO //////////////////////////////////////////////////////////////////
		
		System.out.println("Teste cadastramento:\n");
		try {
			uci.cadastrarFilme(filme1);
				if(uci.existeFilme("Star Wars 1")){
					System.out.println("Filme cadastrado com sucesso.");
				}
		} catch(FilmeCadastradoException error1) {
			System.out.println("Erro: Filme ja cadastrado.");
		}
		try {
			uci.cadastrarFilme(filme2);
				if(uci.existeFilme("Titanic")) {
					System.out.println("Filme cadastrado com sucesso.");
				}
		} catch(FilmeCadastradoException error1) {
			System.out.println("Erro: Filme ja cadastrado.");
		}
		try {
			uci.cadastrarFilme(filme3);
				if(uci.existeFilme("Senhor dos Aneis: A sociedade do anel")) {
					System.out.println("Filme cadastrado com sucesso.");
				}
		} catch(FilmeCadastradoException error1) {
			System.out.println("Erro: Filme ja cadastrado.");
		}
		try {
			uci.cadastrarSala(sala1);
				if(uci.existeSala(1)) {
					System.out.println("Sala cadastrada com sucesso.");
				}
		} catch(SalaJaCriadaException error2) {
			System.out.println("Erro: Sala ja cadastrada.");
		}
		try {
			uci.cadastrarSala(sala2);
				if(uci.existeSala(2)) {
					System.out.println("Sala cadastrada com sucesso.");
				}
		} catch(SalaJaCriadaException error2) {
			System.out.println("Erro: Sala ja cadastrada.");
		}
		try {
			uci.cadastrarSala(sala3);
				if(uci.existeSala(3)) {
					System.out.println("Sala cadastrada com sucesso.");
				}
		} catch(SalaJaCriadaException error2) {
			System.out.println("Erro: Sala ja cadastrada.");
		}
		try {
			uci.cadastrarSessao(sessao1);
				if(uci.existeSessao(1)) {
					System.out.println("Sessao cadastrada com sucesso.");
					System.out.println("Filme: " + sessao1.getFilme().getNome());
					System.out.println("Sala: " + sessao1.getSala().getNumero());
					System.out.println("Valor: R$" + sessao1.getSala().getValor());
				}
		} catch(SessaoJaCadastradaException error3) {
			System.out.println("Erro: Sessao ja cadastrada.");
		} catch(FilmeOuSalaNaoExisteException error4) {
			System.out.println("Erro: Filme ou Sala nao existem.");
		}
		try {
			uci.cadastrarSessao(sessao2);
				if(uci.existeSessao(2)) {
					System.out.println("Sessao cadastrada com sucesso.");
					System.out.println("Filme: " + sessao2.getFilme().getNome());
					System.out.println("Sala: " + sessao2.getSala().getNumero());
					System.out.println("Valor: R$" + sessao2.getSala().getValor());
				}
		} catch(SessaoJaCadastradaException error3) {
			System.out.println("Erro: Sessao ja cadastrada.");
		} catch(FilmeOuSalaNaoExisteException error4) {
			System.out.println("Erro: Filme ou Sala nao existem.");
		}
		try {
			uci.cadastrarSessao(sessao3);
				if(uci.existeSessao(3)) {
					System.out.println("Sessao cadastrada com sucesso.");
					System.out.println("Filme: " + sessao3.getFilme().getNome());
					System.out.println("Sala: " + sessao3.getSala().getNumero());
					System.out.println("Valor: R$" + sessao3.getSala().getValor());
				}
		} catch(SessaoJaCadastradaException error3) {
			System.out.println("Erro: Sessao ja cadastrada.");
		} catch(FilmeOuSalaNaoExisteException error4) {
			System.out.println("Erro: Filme ou Sala nao existem.");
		}
		try {
			uci.cadastrarCompra(compra1);
				if(uci.existeCompra(1)) {
					boolean meia = false;
					System.out.println("Compra cadastrada com sucesso.");
					double preco = compra1.getSessao().getSala().getValor();
					if(compra1.getMeiaEntrada()) {
						meia = true;
						preco= preco/2;
					}
					System.out.println("Preço do ingresso: R$" + preco);
					if(meia) {
						System.out.println("Meia entrada.");
					}
				}
		} catch(SalaNaoEncontradaException error5) {
			System.out.println("Erro: Sala nao encontrada.");
		} catch(SalaLotadaException error6) {
			System.out.println("Erro: Sala lotada.");
		} catch(BilheteExistenteException error7) {
			System.out.println("Erro: Compra ja realizada.");
		} catch(SessaoErrorException error8) {
			System.out.println("Erro: Sessao nao existe.");
		}
		try {
			uci.cadastrarCompra(compra2);
				if(uci.existeCompra(2)) {
					boolean meia = false;
					System.out.println("Compra cadastrada com sucesso.");
					double preco = compra2.getSessao().getSala().getValor();
					if(compra2.getMeiaEntrada()) {
						preco= preco/2;
						meia = true;
					}
					System.out.println("Preço do ingresso: R$" + preco);
					if(meia) {
						System.out.println("Meia entrada.");
					}
				}
		} catch(SalaNaoEncontradaException error5) {
			System.out.println("Erro: Sala nao encontrada.");
		} catch(SalaLotadaException error6) {
			System.out.println("Erro: Sala lotada.");
		} catch(BilheteExistenteException error7) {
			System.out.println("Erro: Compra ja realizada.");
		} catch(SessaoErrorException error8) {
			System.out.println("Erro: Sessao nao existe.");
		}
		try {
			uci.cadastrarCompra(compra3);
				if(uci.existeCompra(3)) {
					boolean meia = false;
					System.out.println("Compra cadastrada com sucesso.");
					double preco = compra3.getSessao().getSala().getValor();
					if(compra3.getMeiaEntrada()) {
						meia = true;
						preco= preco/2;
					}
					System.out.println("Preço do ingresso: R$" + preco);
					if(meia) {
						System.out.println("Meia entrada.");
					}
				}
		} catch(SalaNaoEncontradaException error5) {
			System.out.println("Erro: Sala nao encontrada.");
		} catch(SalaLotadaException error6) {
			System.out.println("Erro: Sala lotada.");
		} catch(BilheteExistenteException error7) {
			System.out.println("Erro: Compra ja realizada.");
		} catch(SessaoErrorException error8) {
			System.out.println("Erro: Sessao nao existe.");
		}
		
////////////////////////// TESTE ATUALIZAÇAO ///////////////////////////////////////////////////////////////
		
		System.out.println("\nTeste atualizaçao e busca:\n");
		
		Filme filme4 = new Filme("Star Wars 1", "Ficcao", 12, 140);
		try {
			uci.atualizarFilme(filme4);
			System.out.println("Filme atualizado com sucesso.");
			System.out.println("Filme: " + uci.procurarFilme("Star Wars 1").getNome());
			System.out.println("Genero: " + uci.procurarFilme("Star Wars 1").getGenero());
			System.out.println("Idade: " + uci.procurarFilme("Star Wars 1").getFaixa());
			System.out.println("Duraçao: " + uci.procurarFilme("Star Wars 1").getDuracao() + " minutos");
		} catch(FilmeNaoEncontradoException error9) {
			System.out.println("Erro: Filme nao foi encontrado.");
		}
		
		SalaNormal sala4 = new SalaNormal(2,60, 0);
		sala4.debitar();
		try {
			uci.atualizarSala(sala4);
			System.out.println("Sala atualizada com sucesso.");
			System.out.println("Numero: " + uci.procurarSala(2).getNumero());
			System.out.println("Quantidade de vagas: " + uci.procurarSala(2).getVagas());
			System.out.println("Disponiveis: " + uci.procurarSala(2).getDisponiveis());
		} catch(SalaNaoEncontradaException error9) {
			System.out.println("Erro: Sala nao foi encontrada.");
		}
		Sessao sessao4 = new Sessao(filme2, sala3, "15:00", 2);
		try {
			uci.atualizarSessao(sessao4);
			System.out.println("Sessao atualizada com sucesso.");
			System.out.println("Filme: " + uci.procurarSessao(2).getFilme().getNome());
			System.out.println("Sala: " + uci.procurarSessao(2).getSala().getNumero());
			System.out.println("Horario: " + uci.procurarSessao(2).getHorario() + "h");
		} catch(SessaoNaoEncontradaException error9) {
			System.out.println("Erro: Sessao nao foi encontrada.");
		}
		Compra compra4 = new Compra(sessao1,false,1);
		try {
			uci.atualizarCompra(compra4);
			System.out.println("Compra atualizada com sucesso.");
			System.out.println("Filme: " + uci.procurarCompra(1).getSessao().getFilme().getNome());
			System.out.println("Sala: " + uci.procurarCompra(1).getSessao().getSala().getNumero());
			boolean meia = false;
			double preco = uci.procurarCompra(1).getSessao().getSala().getValor();
			if(uci.procurarCompra(1).getMeiaEntrada()) {
				preco= preco/2;
				meia = true;
			}
			System.out.println("Preço do ingresso: R$" + preco);
			if(meia) {
				System.out.println("Meia entrada.");
			}
		}  catch(CadastroNaoEncontradoException error9) {
			System.out.println("Erro: Compra nao foi encontrada.");
		}
		
///////////////////////////// TESTE ERROS //////////////////////////////////////////////////////////////////
		
		System.out.println("\nTeste erros:\n");
		try {
			uci.cadastrarSala(sala1);
		} catch(SalaJaCriadaException error2) {
			System.out.println("Erro: Sala ja cadastrada.");
		}
		try {
			uci.cadastrarFilme(filme2);
		} catch(FilmeCadastradoException error1) {
			System.out.println("Erro: Filme ja cadastrado.");
		}
		try {
			uci.cadastrarSessao(sessao3);
		} catch(SessaoJaCadastradaException error3) {  // <<- erro esperado
			System.out.println("Erro: Sessao ja cadastrada.");
		} catch(FilmeOuSalaNaoExisteException error4) {
			System.out.println("Erro: Filme ou Sala nao existem.");
		}
		try {
			uci.cadastrarCompra(compra2);
		} catch(SalaNaoEncontradaException error5) {
			System.out.println("Erro: Sala nao encontrada.");
		} catch(SalaLotadaException error6) {   
			System.out.println("Erro: Sala lotada.");
		} catch(BilheteExistenteException error7) {    // <<- erro esperado
			System.out.println("Erro: Compra ja realizada.");
		} catch(SessaoErrorException error8) {
			System.out.println("Erro: Sessao nao existe.");
		}
		Compra compra5 = new Compra(sessao1, true, 5);
		try {
			uci.cadastrarCompra(compra5);
		} catch(SalaNaoEncontradaException error5) {
			System.out.println("Erro: Sala nao encontrada.");
		} catch(SalaLotadaException error6) { // <<- erro esperado
			System.out.println("Erro: Sala lotada.");
		} catch(BilheteExistenteException error7) {
			System.out.println("Erro: Compra ja realizada.");
		} catch(SessaoErrorException error8) {
			System.out.println("Erro: Sessao nao existe.");
		}
		Sessao sessao5 = new Sessao(filme5,sala2,"14:30",5);
		try {
			uci.cadastrarSessao(sessao5);
		} catch(SessaoJaCadastradaException error3) {
			System.out.println("Erro: Sessao ja cadastrada.");
		} catch(FilmeOuSalaNaoExisteException error4) { // <<- erro esperado
			System.out.println("Erro: Filme ou Sala nao existem.");
		}
		try {
			uci.removerSala(6);
		} catch(SalaNaoEncontradaException error5) {
			System.out.println("Erro: Sala nao encontrada.");
		}
		try {
			uci.removerFilme("Star Wars 2");
		} catch(FilmeNaoEncontradoException error9) {
			System.out.println("Erro: Filme nao foi encontrado.");
		}
		try {
			uci.removerSessao(5);
		} catch(SessaoNaoEncontradaException error9) {
			System.out.println("Erro: Sessao nao foi encontrada.");
		}
		try {
			uci.removerCompra(5);
		} catch(CadastroNaoEncontradoException error9) {
			System.out.println("Erro: Compra nao foi encontrada.");
		}
////////////////////////////// TESTE REMOVER //////////////////////////////////////////////////////////
		System.out.println("\nTeste remover:\n");
		
		try {
			uci.removerCompra(2);
			if(!uci.existeCompra(2)) {
				System.out.println("Compra removida com sucesso.");
			}
		} catch(CadastroNaoEncontradoException error9) {
			System.out.println("Erro: Compra nao foi encontrada.");
		}
		try {
			uci.removerFilme("Titanic");
			if(!uci.existeFilme("Titanic")) {
				System.out.println("Filme removido com sucesso.");
			}
		} catch(FilmeNaoEncontradoException error9) {
			System.out.println("Erro: Filme nao foi encontrado.");
		}
		try {
			uci.removerSessao(2);
			if(!uci.existeSessao(2)) {
				System.out.println("Sessao removida com sucesso.");
			}
		} catch(SessaoNaoEncontradaException error9) {
			System.out.println("Erro: Sessao nao foi encontrada.");
		}
		try {
			uci.removerSala(2);
			if(!uci.existeSala(2)) {
				System.out.println("Sala removida com sucesso.");
			}
		} catch(SalaNaoEncontradaException error9) {
			System.out.println("Erro: Sala nao foi encontrada.");
		}
		
///////////////////////////////// TESTE INSERIR DE VOLTA ////////////////////////////////////////////////
		System.out.println("\nTeste inserir de volta:\n");
		try {
			uci.cadastrarFilme(filme2);
			if(uci.existeFilme("Titanic")) {
				System.out.println("Filme cadastrado com sucesso.");
			}
		} catch(FilmeCadastradoException error1) {
		System.out.println("Erro: Filme ja cadastrado.");
		}
		try {
			uci.cadastrarSala(sala2);
			if(uci.existeSala(2)) {
				System.out.println("Sala cadastrada com sucesso.");
			}
		} catch(SalaJaCriadaException error2) {
			System.out.println("Erro: Sala ja cadastrada.");
		}
		try {
			uci.cadastrarSessao(sessao2);
			if(uci.existeSessao(2)) {
				System.out.println("Sessao cadastrada com sucesso.");
				System.out.println("Filme: " + sessao2.getFilme().getNome());
				System.out.println("Sala: " + sessao2.getSala().getNumero());
				System.out.println("Valor: R$" + sessao2.getSala().getValor());
			}
		} catch(SessaoJaCadastradaException error3) {
			System.out.println("Erro: Sessao ja cadastrada.");
		} catch(FilmeOuSalaNaoExisteException error4) {
			System.out.println("Erro: Filme ou Sala nao existem.");
		}
		try {
			uci.cadastrarCompra(compra2);
			if(uci.existeCompra(1)) {
				boolean meia = false;
				System.out.println("Compra cadastrada com sucesso.");
				double preco = compra2.getSessao().getSala().getValor();
				if(compra2.getMeiaEntrada()) {
					meia = true;
					preco= preco/2;
				}
				System.out.println("Preço do ingresso: R$" + preco);
				if(meia) {
					System.out.println("Meia entrada.");
				}
			}
		} catch(SalaNaoEncontradaException error5) {
			System.out.println("Erro: Sala nao encontrada.");
		} catch(SalaLotadaException error6) {
			System.out.println("Erro: Sala lotada.");
		} catch(BilheteExistenteException error7) {
			System.out.println("Erro: Compra ja realizada.");
		} catch(SessaoErrorException error8) {
			System.out.println("Erro: Sessao nao existe.");
		}
		
		
	}

}
