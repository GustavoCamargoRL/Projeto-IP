package filmes;

public class Filme {
    private String nome;
    private String genero;
    private int faixa_etaria;
    private int duracao;

    public Filme(String nome, String genero, int etaria, int duracao){
        this.nome=nome;
        this.genero=genero;
        this.faixa_etaria=etaria;
        this.duracao=duracao;
    }

    public void setNome(String nome){
        this.nome=nome;
    }

    public void setGenero(String genero){
        this.genero=genero;
    }

    public void setFaixa(int etaria){
        this.faixa_etaria=etaria;
    }

    public void setDuracao(int duracao){
        this.duracao=duracao;
    }

    public String getNome(){
        return this.nome;
    }
    public String getGenero(){
        return this.genero;
    }

    public int getFaixa(){
        return this.faixa_etaria;
    }
    public int getDuracao(){
        return this.duracao;
    }

   

}