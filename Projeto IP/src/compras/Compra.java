package compras;

import sessoes.Sessao;

public class Compra {
	private int id;
	private Sessao sessao;
	private boolean meiaEntrada;
	
	public Compra (Sessao sessao, boolean meiaEntrada, int id) {
		this.id = id;
		this.sessao = sessao;
		this.meiaEntrada = meiaEntrada;
	}

	
	public int getId () {
		return id;
	}
	
	public Sessao getSessao () {
		return sessao;
	}
	
	public boolean getMeiaEntrada () {
		return meiaEntrada;
	}
	
	public void setId (int id) {
		this.id = id;
	}
	
	public void setSessao (Sessao sessao) {
		this.sessao = sessao;
	}
	
	public void setMeiaEntrada (boolean meiaEntrada) {
		this.meiaEntrada = meiaEntrada;
	}
	
}