package telas.cadastro.controller;

import bancoDeDados.UsuarioDAO;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.layout.Region;
import javafx.stage.Stage;
import modelos.Usuario;
import telas.main.LoginTela;

public class CadastroController {

    /** Responsável por controlar os elementos da tela de Cadastro aka CadastroTela.java**/

    @FXML private TextField edtNome;
    @FXML private TextField edtLogin;
    @FXML private TextField edtSenha;
    @FXML private TextField edtConfirmaSenha;

    public void backToLoginScene(ActionEvent e) {
        LoginTela loginTela = new LoginTela();
        try {
            loginTela.start((Stage) ((Node)e.getSource()).getScene().getWindow());
        } catch (Exception e1) {
            e1.printStackTrace();
        }
    }

    public void onCadastrarButtonClicked(ActionEvent e){

        String nome = edtNome.getText();
        String login = edtLogin.getText();
        String senha = edtSenha.getText();
        String confirmaSenha = edtConfirmaSenha.getText();

        boolean temErro = false;
        String msgErro = "";

        if(nome.equals("")){
            temErro = true;
            msgErro = msgErro + "Insira um nome válido.";
        } else if (login.equals("")) {
            temErro = true;
            msgErro = msgErro + "Insira um usuário válido.";
        } else if (senha.equals("") || confirmaSenha.equals("")){
            temErro = true;
            msgErro = msgErro + "Insira senhas válidas.";
        } else if (!senha.equals(confirmaSenha)){
            temErro = true;
            msgErro = msgErro + "As senhas não coincidem.";
        }

        if(temErro) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Toca da Motoca informa");
            alert.setHeaderText("Campos inválidos");
            alert.setContentText(msgErro);
            alert.getDialogPane().setMinHeight(Region.USE_PREF_SIZE);
            alert.showAndWait();
        }
        else {
            Usuario novoUsuario = new Usuario(nome, login, senha);

            UsuarioDAO.SalvarUsuario(novoUsuario);
        }

        backToLoginScene(e);
    }

}
