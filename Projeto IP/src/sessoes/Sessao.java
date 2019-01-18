package sessoes;

import filmes.Filme;
import salas.Sala;

public class Sessao {
    private Filme filme;
    private Sala sala;
    private String horario;
    private int id;


    public Sessao(Filme filme, Sala sala, String horario, int id) {
        this.filme = filme;
        this.sala = sala;
        this.horario = horario;
        this.id = id;
    }
    public Filme getFilme() {
        return filme;
    }

    public void setFilme(Filme filme) {
        this.filme = filme;
    }

    public Sala getSala() {
        return sala;
    }

    public void setSala(Sala sala) {
        this.sala = sala;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
