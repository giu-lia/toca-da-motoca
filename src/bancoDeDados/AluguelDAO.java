package bancoDeDados;

import javafx.scene.control.Alert;
import modelos.Aluguel;

import java.sql.SQLException;
import java.sql.Statement;

public class AluguelDAO extends BancoDeDados {

    /** Manipula a tabela de alugueis no banco de dados. */

    public static void salvarAluguel(Aluguel aluguel){

        /** Insere uma nova instância de Aluguel na tabela. */

        try {
            Statement st = conexao.createStatement();

            String query = "INSERT INTO aluguel VALUES (" +
                    "NULL, " +
                    aluguel.getIdCliente() + ", " +
                    aluguel.getIdVeiculo() + ", " +
                    "\'" + aluguel.getDataRetirada() + "\'," +
                    "\'" + aluguel.getDataRetirada() + "\'," +
                    "\'" + aluguel.getDataDevolucao() + "\'," +
                    "\'" + aluguel.getLocalRetirada() + "\'," +
                    "\'" + aluguel.getLocalDevolucao() + "\'," +
                    aluguel.getCombustivel() + ", " +
                    aluguel.getJaqueta() + ", " +
                    aluguel.getSeguro() + ", " +
                    aluguel.getValorTotal() +
                    ")";

            System.out.print(query);

            st.executeUpdate(query);

            query = "UPDATE veiculos SET disponivel=FALSE WHERE id=" + String.valueOf(aluguel.getIdVeiculo());
            st.executeUpdate(query);

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Sucesso");
            alert.setHeaderText("Aluguel feito com sucesso");
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
