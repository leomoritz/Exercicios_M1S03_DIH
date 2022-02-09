package comentarios;

import java.time.LocalDateTime;
import java.util.Objects;

import interfaces.Moderavel;
import usuarios.Usuario;

public class Comentario implements Comparable<Comentario>, Moderavel {

    private final String comentario;
    private final Usuario usuario;
    private final LocalDateTime dataHoraComentario;
    private Boolean improprio;

    public Comentario(String comentario, Usuario usuario) {
        this.comentario = comentario;
        this.usuario = usuario;
        this.dataHoraComentario = LocalDateTime.now();
        this.improprio = false;
    }

    public String getComentario() {
        return comentario;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public LocalDateTime getDataHoraComentario() {
        return dataHoraComentario;
    }

    public Boolean getImproprio() {
        return improprio;
    }

    public void setImproprio(Boolean improprio) {
        this.improprio = improprio;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Comentario that = (Comentario) o;
        return usuario.equals(that.usuario) && dataHoraComentario.equals(that.dataHoraComentario);
    }

    @Override
    public int hashCode() {
        return Objects.hash(usuario, dataHoraComentario);
    }

    @Override
    public int compareTo(Comentario o) {
        return this.comentario.compareTo(o.getComentario()) + this.usuario.compareTo(o.getUsuario()) + this.dataHoraComentario.compareTo(o.getDataHoraComentario());
    }

    @Override
    public void atribuiConteudoImproprio() {
        setImproprio(true);
    }
}
