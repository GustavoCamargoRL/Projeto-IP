package salas;

public class SalaNormal extends Sala{
		
		public SalaNormal(int numero, int quantVagas, int disponiveis) {
			super (numero, quantVagas, disponiveis);
		}
		
		public void debitar() {
			super.setValor(super.getValor() - 20.0);			//atualiza o valor da sala para 20 reais
		}
}
