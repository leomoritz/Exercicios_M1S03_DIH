package series;

import java.util.Set;
import java.util.TreeSet;

import enums.ClassificacaoEtaria;
import enums.GeneroFilme;
import filmes.Filme;

public class Serie extends Filme {

    private final Set<Episodio> episodios;

    public Serie(String nome, String sinopse, GeneroFilme genero, ClassificacaoEtaria classificacaoEtariaFilme, String linkSerie) {
        super(nome, sinopse, genero, classificacaoEtariaFilme, linkSerie);
        this.episodios = new TreeSet<>();
    }

    public Set<Episodio> getEpisodios() {
        return episodios;
    }
}
