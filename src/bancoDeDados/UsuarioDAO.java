package bancoDeDados;

import javafx.scene.control.Alert;
import modelos.Usuario;
import secao.Secao;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class UsuarioDAO extends BancoDeDados {

    /** Manipula a tabela de usuários no banco de dados. */

    public static void SalvarUsuario(Usuario novoUsuario){

        /** Insere um novo Usuario na tabela. */

        try {
            Statement st = conexao.createStatement();

            String query = "INSERT INTO usuarios VALUES (" +
                    "NULL, " +
                    "\'" + novoUsuario.getNome() + "\'," +
                    "\'" + novoUsuario.getUsuario() + "\'," +
                    "\'" + novoUsuario.getSenha() + "\'" +
                    ")";

            System.out.print(query);

            st.executeUpdate(query);

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Sucesso");
            alert.setHeaderText("Usuário criado com sucesso");
            alert.setContentText("Oi " + novoUsuario.getNome() + "! Você já pode fazer login normalmente :)");
            alert.showAndWait();

        } catch (SQLException e) {

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Ocorreu um erro");
            alert.setHeaderText("Erro ao tentar operar no banco de dados.");
            alert.setContentText(e.getMessage());
            alert.showAndWait();

            e.printStackTrace();
        }
    }

    public static Usuario recuperarUsuario(String login, String senha){

        /** Recupera um usuário de acordo com o campo "usuario" e "senha". */

        try {
            Statement st = conexao.createStatement();

            String query = "SELECT * FROM usuarios WHERE " +
                    "usuario=\'" + login + "\' AND " +
                    "senha=\'" + senha + "\'";

            ResultSet r = st.executeQuery(query);
//            ResultSetMetaData rmd = r.getMetaData();

            Usuario usuario = null;

            if (r.next()){
                usuario = new Usuario();
                usuario.setId(Integer.valueOf(r.getString(1)));
                usuario.setNome(r.getString(2));
                usuario.setUsuario(r.getString(3));
                usuario.setSenha(r.getString(4));
            }

            return usuario;
        }
        catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    public static boolean logarUsuario(Usuario usuario){

        /** Identifica se o usuário que tenta logar no sisteam existe e retorna True ou False. */

        try {
            Statement st = conexao.createStatement();

            String query = "SELECT * FROM usuarios WHERE " +
                    "usuario=\'" + usuario.getUsuario() + "\' AND " +
                    "senha=\'" + usuario.getSenha() + "\'";

            System.out.print(query);

            ResultSet r = st.executeQuery(query);
            ResultSetMetaData rmd = r.getMetaData();

            Usuario usuarioLogado = null;

            if (r.next()){
                usuarioLogado = new Usuario();
                usuarioLogado.setId(Integer.valueOf(r.getString(1)));
                usuarioLogado.setNome(r.getString(2));
                usuarioLogado.setUsuario(r.getString(3));
                usuarioLogado.setSenha(r.getString(4));
            }

            if(usuarioLogado != null){
                Secao.getInstancia().setUsuarioLogado(usuarioLogado);
                return true;
            } else {
                return false;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

}
