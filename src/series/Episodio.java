package series;

import java.time.LocalDate;
import java.util.Objects;

public class Episodio implements Comparable<Episodio> {

    private String nomeEpisodio;
    private Integer temporada;
    private Integer capitulo;
    private String linkEpisodio;
    private final LocalDate dataLancamento;

    public Episodio(String nomeEpisodio, Integer temporada, Integer capitulo, String linkEpisodio, LocalDate dataLancamento) {
        this.nomeEpisodio = nomeEpisodio;
        this.temporada = temporada;
        this.capitulo = capitulo;
        this.linkEpisodio = linkEpisodio;
        this.dataLancamento = dataLancamento;
    }

    public String getNomeEpisodio() {
        return nomeEpisodio;
    }

    public void setNomeEpisodio(String nomeEpisodio) {
        this.nomeEpisodio = nomeEpisodio;
    }

    public Integer getTemporada() {
        return temporada;
    }

    public void setTemporada(Integer temporada) {
        this.temporada = temporada;
    }

    public Integer getCapitulo() {
        return capitulo;
    }

    public void setCapitulo(Integer capitulo) {
        this.capitulo = capitulo;
    }

    public String getLinkEpisodio() {
        return linkEpisodio;
    }

    public void setLinkEpisodio(String linkEpisodio) {
        this.linkEpisodio = linkEpisodio;
    }

    public LocalDate getDataLancamento() {
        return dataLancamento;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Episodio episodio = (Episodio) o;
        return nomeEpisodio.equals(episodio.nomeEpisodio) && temporada.equals(episodio.temporada) && capitulo.equals(episodio.capitulo) && linkEpisodio.equals(episodio.linkEpisodio) && dataLancamento.equals(episodio.dataLancamento);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nomeEpisodio, temporada, capitulo, linkEpisodio, dataLancamento);
    }

    @Override
    public int compareTo(Episodio o) {
        return this.dataLancamento.compareTo(o.dataLancamento);
    }
}
