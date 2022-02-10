package usuarios;

import java.util.HashSet;
import java.util.Set;

import enums.PlanosPlataforma;

public class Conta {

    private final String email;
    private String senha;
    private final Set<Usuario> perfisDoUsuario;
    private UsuarioAssinaturaPlano plano;
    private boolean isAdimplente;

    public Conta(String email, String senha) {
        this.email = email;
        this.senha = senha;
        this.isAdimplente = true;
        this.perfisDoUsuario = new HashSet<>();
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public boolean isAdimplente() {
        return isAdimplente;
    }

    public void setAdimplente(boolean isAdimplente) {
        this.isAdimplente = isAdimplente;
    }

    public String getEmail() {
        return email;
    }

    public UsuarioAssinaturaPlano getPlano() {
        return plano;
    }

    public void setPlano(UsuarioAssinaturaPlano plano) {
        this.plano = plano;
    }

    public Set<Usuario> getPerfisDoUsuario() {
        return perfisDoUsuario;
    }

    public Boolean addPerfilConta(Usuario usuario) throws Exception {

        if (getPerfisDoUsuario().size() > 5) {
            throw new UnsupportedOperationException("A conta atual já possui o limite máximo de perfis." + " Só é possível possuir 5 perfis por conta.");
        }

        getPerfisDoUsuario().add(usuario);

        return true;
    }

    public Double getValorPlano() throws Exception {

        int qtdPerfisConta = getPerfisDoUsuario().size();

        if (qtdPerfisConta < 2) {
            return PlanosPlataforma.BASICO.getPreco();
        }

        if (qtdPerfisConta < 5) {
            return PlanosPlataforma.PADRAO.getPreco() * qtdPerfisConta;
        }

        if (qtdPerfisConta == 5) {
            return PlanosPlataforma.FAMILIA.getPreco();
        }
        throw new Exception("Não foi possível determinar o valor do plano desta conta! Verifique a quantidade de perfis e o preço de cada plano.");
    }

}
