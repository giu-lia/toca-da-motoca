package telas.removerCliente;

import bancoDeDados.ClienteDAO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Region;
import javafx.stage.Stage;
import modelos.Cliente;

import java.util.ArrayList;

public class RemoverClienteController {

    /** Responsável por controlar os elementos da tela de Remover Cliente aka RemoverClienteTela.java**/

    public TableView<Cliente> tableClientes;

    private ObservableList<TableColumn> tableColumnsClientes = FXCollections.observableArrayList(new ArrayList<>());
    private ObservableList<Cliente> clientes = FXCollections.observableArrayList(new ArrayList<>());

    public void init(){

        clientes = ClienteDAO.recuperarClientes();

        tableColumnsClientes.setAll(tableClientes.getColumns());
        tableClientes.setItems(clientes);

        tableColumnsClientes.get(0).setCellValueFactory(new PropertyValueFactory<>("id"));
        tableColumnsClientes.get(1).setCellValueFactory(new PropertyValueFactory<>("nome"));
        tableColumnsClientes.get(2).setCellValueFactory(new PropertyValueFactory<>("idade"));
        tableColumnsClientes.get(3).setCellValueFactory(new PropertyValueFactory<>("telefone"));
        tableColumnsClientes.get(4).setCellValueFactory(new PropertyValueFactory<>("cpf"));

    }

    public void removerCliente(ActionEvent e){
        if(tableClientes.getSelectionModel().getSelectedItem() == null){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Campos inválidos");
            alert.setHeaderText("Selecione um cliente na tabela");
            alert.getDialogPane().setMinHeight(Region.USE_PREF_SIZE);
            alert.showAndWait();
        }
        else {
            ClienteDAO.removerCliente(tableClientes.getSelectionModel().getSelectedItem());

            Stage stage = (Stage) ((Node)e.getSource()).getScene().getWindow();
            stage.close();
        }
    }

}
