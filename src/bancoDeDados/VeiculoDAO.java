package bancoDeDados;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Alert;
import modelos.Veiculo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class VeiculoDAO extends BancoDeDados {

    /** Manipula a tabela de veiculos no banco de dados. */

    public static ArrayList<Veiculo> recuperarVeiculos(){

        /** Recupera todas as motos no Banco de Dados */

        Statement st = null;

        ArrayList<Veiculo> veiculos = new ArrayList<Veiculo>();

        try {
            st = conexao.createStatement();
            String query = "SELECT * FROM veiculos";

            ResultSet r = st.executeQuery(query);

            Veiculo veiculo;

            while(r.next()) {
                veiculo = new Veiculo();
                veiculo.setId(Integer.valueOf(r.getString(1)));
                veiculo.setDisponivel(Boolean.valueOf(r.getString(2)));
                veiculo.setCategoria(Integer.valueOf(r.getString(3)));
                veiculo.setMarca(r.getString(4));
                veiculo.setModelo(r.getString(5));
                veiculo.setAno(Integer.valueOf(r.getString(6)));
                veiculo.setAltura(Float.valueOf(r.getString(7)));
                veiculo.setLargura(Float.valueOf(r.getString(8)));
                veiculo.setPeso(Float.valueOf(r.getString(9)));
                veiculo.setTipoDoMotor(r.getString(10));
                veiculo.setCapacidadeDoTanque(Float.valueOf(r.getString(11)));
                veiculo.setConsumoMedio(Float.valueOf(r.getString(12)));
                veiculo.setPortaDeEnegia(Boolean.parseBoolean(r.getString(13)));
                veiculo.setRadio(Boolean.parseBoolean(r.getString(14)));
                veiculo.setCdPlayer(Boolean.parseBoolean(r.getString(15)));
                veiculo.setEscudoDeVento(Boolean.parseBoolean(r.getString(16)));
                veiculo.setAluguelDiario(Float.valueOf(r.getString(17)));

                veiculos.add(veiculo);
            }

            return veiculos;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    public static ObservableList<Veiculo> recuperarVeiculosDisponiveis(){

        /** Recupera veículos cujo campo "disponivel" é verdadeiro. */

        Statement st = null;

        ObservableList<Veiculo> veiculos = FXCollections.observableArrayList(new ArrayList<>());

        try {
            st = conexao.createStatement();
            String query = "SELECT * FROM veiculos WHERE disponivel=TRUE";

            ResultSet r = st.executeQuery(query);

            Veiculo veiculo;

            while(r.next()) {
                veiculo = new Veiculo();
                veiculo.setId(Integer.valueOf(r.getString(1)));
                veiculo.setDisponivel(Boolean.valueOf(r.getString(2)));
                veiculo.setCategoria(Integer.valueOf(r.getString(3)));
                veiculo.setMarca(r.getString(4));
                veiculo.setModelo(r.getString(5));
                veiculo.setAno(Integer.valueOf(r.getString(6)));
                veiculo.setAltura(Float.valueOf(r.getString(7)));
                veiculo.setLargura(Float.valueOf(r.getString(8)));
                veiculo.setPeso(Float.valueOf(r.getString(9)));
                veiculo.setTipoDoMotor(r.getString(10));
                veiculo.setCapacidadeDoTanque(Float.valueOf(r.getString(11)));
                veiculo.setConsumoMedio(Float.valueOf(r.getString(12)));
                veiculo.setPortaDeEnegia(Boolean.parseBoolean(r.getString(13)));
                veiculo.setRadio(Boolean.parseBoolean(r.getString(14)));
                veiculo.setCdPlayer(Boolean.parseBoolean(r.getString(15)));
                veiculo.setEscudoDeVento(Boolean.parseBoolean(r.getString(16)));
                veiculo.setAluguelDiario(Float.valueOf(r.getString(17)));

                veiculos.add(veiculo);
            }

            return veiculos;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    public static void removerVeiculo(Veiculo veiculo){

        /** Remove uma moto da tabela de acordo com seu ID. */

        try {
            Statement st = conexao.createStatement();

            String query = "DELETE FROM veiculos WHERE id=" + veiculo.getId();

            System.out.print(query);

            st.executeUpdate(query);

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Sucesso");
            alert.setHeaderText("Moto removida com sucesso");
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

    public static void salvarVeiculo(Veiculo veiculo){

        /** Insere um novo Veiculo na tabela. */

        try {
            Statement st = conexao.createStatement();

            String query = "INSERT INTO veiculos VALUES (" +
                    "NULL, " +
                    veiculo.getDisponivel() + ", " +
                    veiculo.getCategoria() + ", " +
                    "\'" + veiculo.getMarca() + "\', " +
                    "\'" + veiculo.getModelo() + "\', " +
                    veiculo.getAno() + ", " +
                    veiculo.getAltura() + ", " +
                    veiculo.getLargura() + ", " +
                    veiculo.getPeso() + ", " +
                    "\'" + veiculo.getTipoDoMotor() + "\', " +
                    veiculo.getCapacidadeDoTanque() + ", " +
                    veiculo.getConsumoMedio() + ", " +
                    veiculo.getPortaDeEnegia() + ", " +
                    veiculo.getRadio() + ", " +
                    veiculo.getCdPlayer() + ", " +
                    veiculo.getEscudoDeVento() + ", " +
                    veiculo.getAluguelDiario() +
                    ")";

            System.out.print(query);

            st.executeUpdate(query);

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Sucesso");
            alert.setHeaderText("Moto adicionada com sucesso");
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

}
