package telas.cadastrarCliente;

import bancoDeDados.ClienteDAO;
import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.layout.Region;
import javafx.stage.Stage;
import modelos.Cliente;

public class CadastrarClienteController {

    /** Responsável por controlar os elementos da tela de Cadastrar Cliente aka CadastrarClienteTela.**/

    public TextField edtNome;
    public TextField edtCPF;
    public TextField edtIdade;
    public TextField edtTelefone;

    public void salvarCliente(ActionEvent e){

        boolean temErro = false;
        String msgErro = "";

        // obrigatorios

        if(edtNome.getText().equals("")){
            temErro = true;
            msgErro = "Informe o nome do cliente.";
        }

        if(edtCPF.getText().equals("")){
            temErro = true;
            msgErro = "Informe o CPF do cliente.";
        }

        if(edtIdade.getText().equals("") || Integer.valueOf(edtIdade.getText()) < 18){
            temErro = true;
            msgErro = "Informe a idade do cliente.";
        }

        if(edtTelefone.getText().equals("")){
            temErro = true;
            msgErro = "Informe o telefone do cliente.";
        }

        if(temErro){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Campos inválidos");
            alert.setContentText(msgErro);
            alert.getDialogPane().setMinHeight(Region.USE_PREF_SIZE);
            alert.showAndWait();
        } else {
            Cliente cliente = new Cliente(edtNome.getText(), Integer.valueOf(edtIdade.getText()), edtTelefone.getText(), edtCPF.getText());

            ClienteDAO.salvarCliente(cliente);
            Stage stage = (Stage) ((Node)e.getSource()).getScene().getWindow();
            stage.close();
        }

    }

}
