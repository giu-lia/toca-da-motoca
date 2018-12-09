package bancoDeDados;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class BancoDeDados {

    /** Define as conexões com o banco de dados local. */

    private static String TAG = "BANCO DE DADOS: ";
    private static String user = "root";
    private static String pass = "123456";
    protected static Connection conexao = null;

    public BancoDeDados() {
        if (conexao == null) conecta();
    }

    private static void conecta() {

        /** Cria a conexão com o banco. Se o banco "toca_da_motoca" não existir, ele criará um novo. */

        try {
            String url = "jdbc:mysql://localhost:3306/toca_da_motoca";

            conexao = DriverManager.getConnection(url, user, pass);

            System.out.println(TAG + "existe!");
        }

        catch (SQLException e) {
            if(e.getErrorCode() == 1049) {
                System.out.println(TAG + "nao existe");
                criaBancoDeDados();
            }
        }
    }

    private static void criaBancoDeDados(){

        /** Cria o banco de dados "toca_da_motoca" no caso de ele não existir localmente. */

        try {
            System.out.println(TAG + "tentando criar banco");

            String url = "jdbc:mysql://localhost:3306";

            conexao = DriverManager.getConnection(url, user, pass);
            Statement s = conexao.createStatement();

            int resultado = s.executeUpdate("CREATE DATABASE toca_da_motoca");
            resultado = s.executeUpdate("USE toca_da_motoca");

            System.out.println(TAG + "criou!");
            criaTabelas();
            insereDados();
        }

        catch (SQLException e) {
            System.out.print(e.getMessage());
        }
    }

    private static void criaTabelas() {

        /** Cria as tabelas "veiculos", "clientes", "usuarios" e "aluguel" no banco de dados. */

        try {
            Statement s = conexao.createStatement();
            s.executeUpdate("CREATE TABLE veiculos (\n" +
                    "id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,\n" +
                    "disponivel BOOL, \n" +
                    "categoria INT NOT NULL,\n" +
                    "marca VARCHAR(20),\n" +
                    "modelo VARCHAR(30),\n" +
                    "ano INT,\n" +
                    "altura FLOAT,\n" +
                    "largura FLOAT,\n" +
                    "peso FLOAT,\n" +
                    "tipo_do_motor VARCHAR(30),\n" +
                    "capacidade_do_tanque FLOAT,\n" +
                    "consumo_medio FLOAT,\n" +
                    "porta_de_energia BOOL,\n" +
                    "radio BOOL,\n" +
                    "cd_player BOOL,\n" +
                    "escudo_de_vento BOOL,\n" +
                    "aluguel_diario FLOAT\n" +
                    ");");

            s.executeUpdate("CREATE TABLE usuarios (\n" +
                    "id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,\n" +
                    "nome VARCHAR(20),\n" +
                    "usuario VARCHAR(20),\n" +
                    "senha VARCHAR(20)\n" +
                    ");");

            s.executeUpdate("CREATE TABLE clientes (\n" +
                    "id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,\n" +
                    "nome VARCHAR(20),\n" +
                    "idade INT,\n" +
                    "telefone VARCHAR(20),\n" +
                    "cpf VARCHAR(20)" +
                    ");");

            s.executeUpdate("CREATE TABLE aluguel (\n" +
                    "id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,\n" +
                    "id_cliente INT,\n" +
                    "id_veiculo INT,\n" +
                    "feito_em DATE,\n" +
                    "data_retirada VARCHAR(20),\n" +
                    "data_devolucao VARCHAR(20),\n" +
                    "local_retirada VARCHAR(60),\n" +
                    "local_devolucao VARCHAR(60),\n" +
                    "combustivel FLOAT,\n" +
                    "jaqueta FLOAT,\n" +
                    "seguro FLOAT,\n" +
                    "valor_total FLOAT\n" +
                    ");");

            s.executeUpdate("ALTER TABLE aluguel ADD CONSTRAINT FOREIGN KEY (id_cliente) REFERENCES clientes(id);");

            s.executeUpdate("ALTER TABLE aluguel ADD CONSTRAINT FOREIGN KEY (id_veiculo) REFERENCES veiculos(id);");

        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void insereDados() {

        /** Insere dados de teste no banco de dados. */

        try {
            Statement s = conexao.createStatement();

            s.executeUpdate("INSERT INTO usuarios VALUES (NULL, \"Giulia\", \"giu\", \"123456\");");
            s.executeUpdate("INSERT INTO usuarios VALUES (NULL, \"Horacio\", \"horacio\", \"123456\");");

            // Adiciona veículos

            s.executeUpdate("INSERT INTO veiculos VALUES (NULL, true, 1, \"Honda\", \"Pop 100i\", 2018, 1033.00, 745.00, 87.00, \"Monocilíndrico\", 4.22, 10.00, TRUE, FALSE, FALSE, TRUE, 110.00);");
            s.executeUpdate("INSERT INTO veiculos VALUES (NULL, true, 3, \"Honda\", \"Biz 4500\", 2017, 1023.40, 800.20, 50.00, \"Muito bom\", 10, 2.00, TRUE, TRUE, TRUE, TRUE, 343.50);\n");
            s.executeUpdate("INSERT INTO veiculos VALUES (NULL, true, 2, \"Samsung\", \"Galaxy Motão\", 2000, 1340.10, 812.20, 102.20, \"O melhor mais barato\", 4.80, 4.30, TRUE, TRUE, FALSE, FALSE, 143.00);\n");
            s.executeUpdate("INSERT INTO veiculos VALUES (NULL, true, 1, \"Lenovo\", \"LG 23X\", 2015, 2300.00, 340.10, 72.75, \"Motorizado\", 6.20, 2, TRUE, TRUE, TRUE, TRUE, 343.50);");

            // Adiciona clientes

            s.executeUpdate("INSERT INTO clientes VALUES(NULL, \"Lorena de Jesus\", 20, \"9299999999\", \"12345678900\");");
            s.executeUpdate("INSERT INTO clientes VALUES(NULL, \"Fran\", 19, \"9299995555\", \"12345678900\");");
            s.executeUpdate("INSERT INTO clientes VALUES(NULL, \"Lulinho\", 16, \"9291234567\", \"12345678900\");");
            s.executeUpdate("INSERT INTO clientes VALUES(NULL, \"Gustavo Mondaineko\", 12, \"92887777881\", \"12345678900\");");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static boolean desconecta() {

        /** Desconecta o programa do banco de dados. */

        try {
            conexao.close();
            return true;
        } catch (SQLException e) {
            return false;
        }
    }

}
