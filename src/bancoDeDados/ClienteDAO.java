package bancoDeDados;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Alert;
import modelos.Cliente;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class ClienteDAO extends BancoDeDados {

    /** Manipula a tabela de clientes no banco de dados. **/

    public static ObservableList<Cliente> recuperarClientes(){

        /** Recupera do banco de dados todos os clientes na tabela. */

        Statement st = null;

        ObservableList<Cliente> clientes = FXCollections.observableArrayList(new ArrayList<>());

        try {
            st = conexao.createStatement();
            String query = "SELECT * FROM clientes";

            ResultSet r = st.executeQuery(query);

            Cliente cliente;

            while(r.next()) {
                cliente = new Cliente();
                cliente.setId(Integer.valueOf(r.getString(1)));
                cliente.setNome(r.getString(2));
                cliente.setIdade(Integer.valueOf(r.getString(3)));
                cliente.setTelefone(r.getString(4));
                cliente.setCpf(r.getString(5));

                clientes.add(cliente);
            }

            System.out.print(clientes);
            return clientes;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    public static void salvarCliente(Cliente cliente){

        /** Insere na tabela "clientes" um novo Cliente. */

        try {
            Statement st = conexao.createStatement();

            String query = "INSERT INTO clientes VALUES (" +
                    "NULL, " +
                    "\'" + cliente.getNome() + "\'," +
                    cliente.getIdade() + ", " +
                    "\'" + cliente.getTelefone() +"\', " +
                    "\'" + cliente.getCpf() +"\'" +
                    ")";

            System.out.print(query);

            st.executeUpdate(query);

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Sucesso");
            alert.setHeaderText("Usuário criado com sucesso");
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

    public static void removerCliente(Cliente cliente){

        /** Remove um cliente da tabela pelo seu ID. */

        try {
            Statement st = conexao.createStatement();

            String query = "DELETE FROM clientes WHERE id=" + cliente.getId();

            System.out.print(query);

            st.executeUpdate(query);

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Sucesso");
            alert.setHeaderText("Usuário removido com sucesso");
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
