package telas.main.controller;

import bancoDeDados.UsuarioDAO;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.layout.Region;
import javafx.stage.Stage;
import modelos.Usuario;
import secao.Secao;
import telas.cadastro.CadastroTela;
import telas.menu.MenuTela;

public class LoginController {

    /** Responsável por controlar os elementos da tela de Login.**/

    @FXML private TextField edtUsuario;
    @FXML private TextField edtSenha;

    public void irParaTelaDeCadastro(ActionEvent e){

        /** Abre a tela de cadastro como nova janela. **/

        CadastroTela cadastroTela = new CadastroTela();
        try {
            Stage newWindow = new Stage();
            cadastroTela.start(newWindow);
        } catch (Exception e1) {
            e1.printStackTrace();
        }
    }

    public void irParaMenuPrincipal(ActionEvent e){

        /**
         * Abre a tela do menu na mesma janela.
         * **/

        MenuTela menuTela = new MenuTela();
        try {
            menuTela.start((Stage) ((Node)e.getSource()).getScene().getWindow());
        } catch (Exception e1) {
            e1.printStackTrace();
        }
    }

    public void onCriarUmaContaClicked(ActionEvent e) {

        /** Abre a tela de cadastro como nova janela. **/

        irParaTelaDeCadastro(e);
    }

    public void onLogInButtonClicked(ActionEvent e){

        /** Loga o usuário no sistema. **/

        String login = "";
        String senha = "";

        boolean temErro = false;
        String msgErro = "";

        if(edtUsuario.getText().equals("")){
            temErro = true;
            msgErro = msgErro + "Insira um usuário válido.";
        }
        if(edtSenha.getText().equals("")){
            temErro = true;
            msgErro = msgErro + "Insira uma senha válida.";
        }

        if(temErro) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Campos inválidos");
            alert.setContentText(msgErro);
            alert.getDialogPane().setMinHeight(Region.USE_PREF_SIZE);
            alert.showAndWait();
        }
        else {
            login = edtUsuario.getText();
            senha = edtSenha.getText();
        }

        Usuario usuario = UsuarioDAO.recuperarUsuario(login, senha);

        if(usuario != null){
            Secao.getInstancia().setUsuarioLogado(usuario);
            irParaMenuPrincipal(e);
        }
        else {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Toca da Motoca informa");
            alert.setHeaderText("Usuário não existe");
            alert.setContentText("Nome de usuário ou senha incorretos.");
            alert.getDialogPane().setMinHeight(Region.USE_PREF_SIZE);
            alert.showAndWait();
        }
    }

}
