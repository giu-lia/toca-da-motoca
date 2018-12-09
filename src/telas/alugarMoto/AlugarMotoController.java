package telas.alugarMoto;

import bancoDeDados.AluguelDAO;
import bancoDeDados.VeiculoDAO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Region;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import modelos.Aluguel;
import modelos.Cliente;
import bancoDeDados.ClienteDAO;
import modelos.Veiculo;

import java.sql.Date;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;

public class AlugarMotoController {

    /** Responsável por controlar os elementos da tela de Alugar Moto aka AlugarMotoTela.java.**/

    public TextField edtIdMoto;
    public TableView<Veiculo> tableMotos;
    public TableView<Cliente> tableClientes;
    public TextField edtIdCliente;
    public DatePicker dateRetirada;
    public TextField edtLocalRetirada;
    public DatePicker dateDevolucao;
    public TextField edtLocalDevolucao;
    public TextField edtCombustivel;
    public TextField edtJaqueta;
    public TextField edtSeguro;
    public Text txtTotal;
    public Button btnCalcular;
    public Button btnFinalizar;

    private ObservableList<TableColumn> tableColumnsClientes = FXCollections.observableArrayList(new ArrayList<>());
    private ObservableList<Cliente> clientes = FXCollections.observableArrayList(new ArrayList<>());

    private ObservableList<TableColumn> tableColumnsMotos = FXCollections.observableArrayList(new ArrayList<>());
    private ObservableList<Veiculo> motos = FXCollections.observableArrayList(new ArrayList<>());


    public void init(){

        clientes = ClienteDAO.recuperarClientes();

        tableColumnsClientes.setAll(tableClientes.getColumns());
        tableClientes.setItems(clientes);

        tableColumnsClientes.get(0).setCellValueFactory(new PropertyValueFactory<>("id"));
        tableColumnsClientes.get(1).setCellValueFactory(new PropertyValueFactory<>("nome"));
        tableColumnsClientes.get(2).setCellValueFactory(new PropertyValueFactory<>("idade"));
        tableColumnsClientes.get(3).setCellValueFactory(new PropertyValueFactory<>("telefone"));
        tableColumnsClientes.get(4).setCellValueFactory(new PropertyValueFactory<>("cpf"));

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

    public void calcularTotal(ActionEvent e){

        boolean temErro = false;
        String msgErro = "";

        // obrigatorios

        if(tableMotos.getSelectionModel().getSelectedItem() == null){
            temErro = true;
            msgErro = "Selecione uma moto.";
        }

        if(dateRetirada.getValue() == null){
            temErro = true;
            msgErro = "Selecione uma data para retirada.";
        }

        if(dateDevolucao.getValue() == null){
            temErro = true;
            msgErro = "Selecione uma data para devolucao.";
        }

        if(temErro){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Campos inválidos");
            alert.setHeaderText("Campos inválidos");
            alert.setContentText(msgErro);
            alert.getDialogPane().setMinHeight(Region.USE_PREF_SIZE);
            alert.showAndWait();
        }
        else {
            Float jaqueta = 0f;
            if (!edtJaqueta.getText().equals("")) {
                jaqueta = Float.valueOf(edtJaqueta.getText().replace(',', '.'));
            }

            Float seguro = 0f;
            if (!edtSeguro.getText().equals("")) {
                jaqueta = Float.valueOf(edtSeguro.getText().replace(',', '.'));
            }

            Float combustivel = 0f;
            if (!edtCombustivel.getText().equals("")) {
                jaqueta = Float.valueOf(edtCombustivel.getText().replace(',', '.'));
            }

            Veiculo moto = tableMotos.getSelectionModel().getSelectedItem();

            Float opcionais = jaqueta + seguro + combustivel;
            Float diarias = moto.getAluguelDiario() * ChronoUnit.DAYS.between(dateRetirada.getValue(), dateDevolucao.getValue());

            Float total = opcionais + diarias;

            txtTotal.setText("R$ " + total.toString());
        }
    }

    public void salvarAluguel(ActionEvent e){

        boolean temErro = false;
        String msgErro = "";

        // obrigatorios

        if(tableClientes.getSelectionModel().getSelectedItem() == null){
            temErro = true;
            msgErro = "Selecione um cliente.";
        }

        if(tableMotos.getSelectionModel().getSelectedItem() == null){
            temErro = true;
            msgErro = "Selecione uma moto.";
        }
        
        if(dateRetirada.getValue() == null){
            temErro = true;
            msgErro = "Selecione uma data para retirada.";
        }

        if(dateDevolucao.getValue() == null){
            temErro = true;
            msgErro = "Selecione uma data para devolucao.";
        }
        
        if(edtLocalRetirada.getText().equals("")){
            temErro = true;
            msgErro = "Informe o local para retirada.";
        }

        if(edtLocalDevolucao.getText().equals("")){
            temErro = true;
            msgErro = "Informe o local para devolucao.";
        }

        if(temErro){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Campos inválidos");
            alert.setContentText(msgErro);
            alert.getDialogPane().setMinHeight(Region.USE_PREF_SIZE);
            alert.showAndWait();
        } else {

            Float jaqueta = 0f;
            if(!edtJaqueta.getText().equals("")){
                jaqueta = Float.valueOf(edtJaqueta.getText().replace(',', '.'));
            }

            Float seguro = 0f;
            if(!edtSeguro.getText().equals("")){
                jaqueta = Float.valueOf(edtSeguro.getText().replace(',', '.'));
            }

            Float combustivel = 0f;
            if(!edtCombustivel.getText().equals("")){
                jaqueta = Float.valueOf(edtCombustivel.getText().replace(',', '.'));
            }

            Cliente cliente = tableClientes.getSelectionModel().getSelectedItem();
            Veiculo moto = tableMotos.getSelectionModel().getSelectedItem();
            Date dataRetirada = Date.valueOf(dateRetirada.getValue());
            Date dataDevolucao = Date.valueOf(dateDevolucao.getValue());
            String localRetirada = edtLocalRetirada.getText();
            String localDevolucao = edtLocalDevolucao.getText();

            System.out.println(ChronoUnit.DAYS.between(dateRetirada.getValue(), dateDevolucao.getValue()));

            Float opcionais = jaqueta + seguro + combustivel;
            Float diarias = moto.getAluguelDiario() * ChronoUnit.DAYS.between(dateRetirada.getValue(), dateDevolucao.getValue());

            Float total = opcionais + diarias;

            Aluguel aluguel = new Aluguel(cliente.getId(), moto.getId(), Date.valueOf(LocalDate.now()), dataRetirada, dataDevolucao, localRetirada,
                    localDevolucao, combustivel, jaqueta, seguro, total);

            AluguelDAO.salvarAluguel(aluguel);

            Stage stage = (Stage) ((Node)e.getSource()).getScene().getWindow();
            stage.close();
        }



    }

}
