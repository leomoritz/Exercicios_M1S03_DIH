package usuarios;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;
import java.util.TreeSet;
import java.util.UUID;

import enums.GeneroFilme;
import filmes.Filme;
import filmes.GeneroAssistido;
import interfaces.GeneroMaisAssistido;
import usuarios.enderecos.Endereco;

public class Usuario implements GeneroMaisAssistido, Comparable<Usuario> {

    private final Long idUsuario;
    private String nome;
    private Endereco endereco;
    private final LocalDate dataNascimento;
    private GeneroAssistido generoMaisAssistidoUsuario;

    private List<IndicacaoFilmeUsuario> indicacoesRecebidas = new ArrayList<>();
    private Set<GeneroAssistido> generosAssistidos = new TreeSet<>();
    private Set<Filme> filmesCurtidos = new TreeSet<>();
    private Set<Filme> filmesDescurtidos = new TreeSet<>();

    public Usuario(String nome, Endereco endereco, LocalDate dataNascimento) {
        idUsuario = UUID.randomUUID().getMostSignificantBits();
        this.nome = nome;
        this.endereco = endereco;
        this.dataNascimento = dataNascimento;
    }

    public Long getIdUsuario() {
        return idUsuario;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Usuario usuario = (Usuario) o;
        return idUsuario.equals(usuario.idUsuario);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idUsuario);
    }

    @Override
    public int compareTo(Usuario o) {
        return idUsuario.compareTo(o.getIdUsuario());
    }

}
