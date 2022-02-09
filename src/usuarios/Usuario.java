package usuarios;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;
import java.util.TreeSet;

import enums.GeneroFilme;
import filmes.Filme;
import filmes.GeneroAssistido;
import interfaces.GeneroMaisAssistido;

public class Usuario implements GeneroMaisAssistido, Comparable<Usuario> {

    private String nome;
    private String endereco;
    private final LocalDate dataNascimento;
    private GeneroAssistido generoMaisAssistidoUsuario;

    private List<IndicacaoFilmeUsuario> indicacoesRecebidas = new ArrayList<>();
    private Set<GeneroAssistido> generosAssistidos = new TreeSet<>();
    private Set<Filme> filmesCurtidos = new TreeSet<>();
    private Set<Filme> filmesDescurtidos = new TreeSet<>();

    public Usuario(String nome, String endereco, LocalDate dataNascimento) {
        this.nome = nome;
        this.endereco = endereco;
        this.dataNascimento = dataNascimento;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public List<IndicacaoFilmeUsuario> getIndicacoesRecebidas() {
        return indicacoesRecebidas;
    }

    public Set<GeneroAssistido> getGenerosAssistidosUsuario() {
        return generosAssistidos;
    }

    private Optional<GeneroAssistido> getGeneroMaisAssistidoUsuario() {
        return Optional.ofNullable(generoMaisAssistidoUsuario);
    }

    private void setGeneroMaisAssistidoUsuario(GeneroAssistido generoMaisAssistidoUsuario) {
        this.generoMaisAssistidoUsuario = generoMaisAssistidoUsuario;
    }

    public Set<Filme> getFilmesCurtidos() {
        return filmesCurtidos;
    }

    public int getIdadeUsuario() {
        return LocalDate.now().getYear() - getDataNascimento().getYear();

    }

    public void addFilmeCurtido(Filme filme) {
        this.getFilmesCurtidos().add(filme);
    }

    public Set<Filme> getFilmesDescurtidos() {
        return filmesDescurtidos;
    }

    public void addFilmeDescurtido(Filme filme) {
        this.getFilmesDescurtidos().add(filme);
    }

    @Override
    public Boolean addGeneroAssistido(GeneroFilme genero) {

        if (getGenerosAssistidosUsuario().add(new GeneroAssistido(genero, 1))) {
            return true;
        }

        for (GeneroAssistido generoAssistido : getGenerosAssistidosUsuario()) {
            if (generoAssistido.getGeneroAssistido().equals(genero)) {
                generoAssistido.setQtdAssistido(generoAssistido.getQtdAssistido() + 1);
                return true;
            }
        }

        return false;
    }

    @Override
    public GeneroFilme getGeneroMaisAssistido() {
        for (GeneroAssistido generoMaisAssistido : getGenerosAssistidosUsuario()) {

            if (!getGeneroMaisAssistidoUsuario().isPresent()) {
                setGeneroMaisAssistidoUsuario(generoMaisAssistido);
            }

            if (generoMaisAssistido.getQtdAssistido() > getGeneroMaisAssistidoUsuario().get().getQtdAssistido()) {
                setGeneroMaisAssistidoUsuario(generoMaisAssistido);
            }
        }

        return getGeneroMaisAssistidoUsuario().get().getGeneroAssistido();

    }

    @Override
    public int hashCode() {
        return Objects.hash(dataNascimento, endereco, nome);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (getClass() != obj.getClass()) return false;
        Usuario other = (Usuario) obj;
        return Objects.equals(dataNascimento, other.dataNascimento) && Objects.equals(endereco, other.endereco) && Objects.equals(nome, other.nome);
    }

    @Override
    public int compareTo(Usuario o) {
        return nome.compareTo(o.getNome()) + endereco.compareTo(o.getEndereco()) + dataNascimento.compareTo(o.getDataNascimento());
    }

}
