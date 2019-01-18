package salas;

public abstract class Sala {
	private int quantVagas;
	private int disponiveis;
	private int numero;
	private double valor;
	
	Sala(int numero, int quantVagas, int disponiveis){
		this.quantVagas = quantVagas;				//quantidade de vagas que a sala suporta
		this.disponiveis = disponiveis;				//numero de cadeiras disponiveis para compra
		this.valor = 40.0;					//valor teto do ingresso
		this.numero = numero; 				//numero da sala (identificador)
	}
	
	////////metodos para adquirir dados////////
	
	public int getVagas() {
		return quantVagas;
	}
	
	public int getDisponiveis() {
		return disponiveis;
	}
	
	public int getNumero() {
		return numero;
	}
	
	public double getValor() {
		return valor;
	}

	/////// metodos para atualizar dados///////
	
	public void setValor(double valor) {
		this.valor = valor;
	}
	
	public void setVagas(int vagas) {
		this.quantVagas = vagas;
	}
	
	public void setDisponiveis(int disponiveis) {
		this.disponiveis = disponiveis;
	}
	
	public void setLotacao() {
		this.disponiveis--;
	}
	
}
