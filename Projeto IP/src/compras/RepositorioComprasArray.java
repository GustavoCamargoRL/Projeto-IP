package compras;

public class RepositorioComprasArray 
implements RepositorioCompras {

private Compra[] compras;
private int indice;

public RepositorioComprasArray(int tamanho) {
compras = new Compra [tamanho];
}

public void cadastrar (Compra c) throws BilheteExistenteException{
boolean i = this.existe(c.getId());
if (i == true) {
	throw new BilheteExistenteException();
} else {
	compras [indice] = c;
	indice = indice + 1;
}
}

public void atualizar (Compra c)
					throws CadastroNaoEncontradoException {
int i = this.getIndice (c.getId());
if (i == this.indice) {
	throw new CadastroNaoEncontradoException();
} else {	
	this.compras[i] = c;
}
}

public void remover (int id) 
		throws CadastroNaoEncontradoException{
int i = this.getIndice (id);
if (i == this.indice) {
throw new CadastroNaoEncontradoException();
} else {
for (int j = i; j < this.indice; j++) {
if (j == i) {
	this.compras[j] = null;
} else if (j != i) {
this.compras[j - 1] = this.compras[j];
}
if (this.compras[j+1] == null) {
	this.compras[j] = null;
}
}
this.indice = this.indice - 1;
}
}

public Compra procurar (int id) 
					throws CadastroNaoEncontradoException{
Compra c = null;
int i = this.getIndice (id);
if (i == this.indice) {
	throw new CadastroNaoEncontradoException();
} else {
	c = this.compras[i];
}
return c;
}

public boolean existe (int id) {
int i = this.getIndice (id);
return (i != this.indice);
}

private int getIndice (int id) {
int num;
boolean achou = false;
int i = 0;
while ((!achou) && (i < this.indice)) {
	num = compras[i].getId();
	if (num == id) {
		achou = true;
	} else {
		i = i + 1;
	}
}
return i;
}

}
