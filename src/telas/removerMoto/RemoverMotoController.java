package telas.removerMoto;

import bancoDeDados.VeiculoDAO;
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
import modelos.Veiculo;

import java.util.ArrayList;

public class RemoverMotoController {

    /** Responsável por controlar os elementos da tela de Remover Moto aka RemoverMotoTela.**/

    public TableView<Veiculo> tableMotos;
    private ObservableList<TableColumn> tableColumnsMotos = FXCollections.observableArrayList(new ArrayList<>());
    private ObservableList<Veiculo> motos = FXCollections.observableArrayList(new ArrayList<>());

    public void init(){

        motos = VeiculoDAO.recuperarVeiculosDisponiveis();

        tableColumnsMotos.setAll(tableMotos.getColumns());
        tableMotos.setItems(motos);

        System.out.println(tableColumnsMotos.toString());

        tableColumnsMotos.get(0).setCellValueFactory(new PropertyValueFactory<>("id"));
        tableColumnsMotos.get(1).setCellValueFactory(new PropertyValueFactory<>("categoria"));
        tableColumnsMotos.get(2).setCellValueFactory(new PropertyValueFactory<>("marca"));
        tableColumnsMotos.get(3).setCellValueFactory(new PropertyValueFactory<>("modelo"));
        tableColumnsMotos.get(4).setCellValueFactory(new PropertyValueFactory<>("ano"));
        tableColumnsMotos.get(5).setCellValueFactory(new PropertyValueFactory<>("altura"));
        tableColumnsMotos.get(6).setCellValueFactory(new PropertyValueFactory<>("largura"));
        tableColumnsMotos.get(7).setCellValueFactory(new PropertyValueFactory<>("peso"));
        tableColumnsMotos.get(8).setCellValueFactory(new PropertyValueFactory<>("tipoDoMotor"));
        tableColumnsMotos.get(9).setCellValueFactory(new PropertyValueFactory<>("capacidadeDoTanque"));
        tableColumnsMotos.get(10).setCellValueFactory(new PropertyValueFactory<>("consumoMedio"));
        tableColumnsMotos.get(11).setCellValueFactory(new PropertyValueFactory<>("portaDeEnegia"));
        tableColumnsMotos.get(12).setCellValueFactory(new PropertyValueFactory<>("radio"));
        tableColumnsMotos.get(13).setCellValueFactory(new PropertyValueFactory<>("cdPlayer"));
        tableColumnsMotos.get(14).setCellValueFactory(new PropertyValueFactory<>("escudoDeVento"));
        tableColumnsMotos.get(15).setCellValueFactory(new PropertyValueFactory<>("aluguelDiario"));
    }

    public void removerMoto(ActionEvent e){

        Veiculo moto = tableMotos.getSelectionModel().getSelectedItem();

        if(moto == null){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Campos inválidos");
            alert.setHeaderText("Selecione uma moto na tabela");
            alert.getDialogPane().setMinHeight(Region.USE_PREF_SIZE);
            alert.showAndWait();
        }
        else {
            if(!moto.getDisponivel()){
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Moto indisponível");
                alert.setHeaderText("A moto está alugada no momento.");
                alert.getDialogPane().setMinHeight(Region.USE_PREF_SIZE);
                alert.showAndWait();
             }
             else {
                VeiculoDAO.removerVeiculo(tableMotos.getSelectionModel().getSelectedItem());

                Stage stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
                stage.close();
            }
        }
    }

}
