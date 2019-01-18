package salas;

public class Sala3D extends Sala{
		public Sala3D(int numero, int quantVagas, int disponiveis) {
			super(numero, quantVagas, disponiveis);
		}
		
		public void debitar() {
			super.setValor(super.getValor() - 10.0);		//atualiza o valor da sala para 30 reais
		}
}
