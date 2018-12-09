package secao;

import modelos.Usuario;

public final class Secao {

    private static final Secao INSTANCIA = new Secao();
    private Usuario usuarioLogado;

    public static Secao getInstancia(){
        return INSTANCIA;
    }

    public Usuario getUsuarioLogado(){
        return usuarioLogado;
    }

    public void setUsuarioLogado(Usuario usuario){
        this.usuarioLogado = usuario;
    }

}
