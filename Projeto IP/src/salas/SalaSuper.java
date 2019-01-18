package salas;

public class SalaSuper extends Sala{
		public SalaSuper(int numero, int quantVagas, int disponiveis) {
			super(numero, quantVagas, disponiveis);
		}
		
		public void debitar() {
			super.setValor(super.getValor());			//mantem o valor da sala
		}
}
