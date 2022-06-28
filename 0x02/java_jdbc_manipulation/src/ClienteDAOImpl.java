import java.sql.*;
import javax.sql.*;

public class ClienteDAOImpl implements ClienteDAO{
    public Connection connect(String urlConexao) {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(urlConexao);
        }
        catch (SQLException e) {
            System.out.println("Não foi possível estabelecer conexão com o banco de dados!");
        }
        return connection;
    }

    public void createTable(String urlConexao) {
        try {
            Connection connection = connect(urlConexao);
            Statement stmt = connection.createStatement();
            stmt.executeUpdate("DROP TABLE IF EXISTS cliente;");

            stmt.executeUpdate("CREATE TABLE cliente (id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, nome VARCHAR(80) NOT NULL," +
                    " idade INTEGER NOT NULL, cpf VARCHAR(20) NOT NULL, rg VARCHAR(20) NOT NULL);");
            stmt.close();
            connection.close();
        } catch (SQLException e) {
            System.out.println("Não foi possível criar tabela!");
        }
    }

    public void insert(String url_conexao, Cliente cliente) {
        try {
            Connection connection = connect(url_conexao);
            Statement stmt = connection.createStatement();

            String query = "INSERT INTO cliente (nome, idade, cpf, rg) VALUES ('" + cliente.getNome() + "', " + cliente.getIdade() + ", '" + cliente.getCpf() + "', '" + cliente.getRg() + "');";

            stmt.executeUpdate(query);

            stmt.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace(System.out);
            System.out.println("Não foi possível inserir na tabela!");
        }
    }

    public void selectAll(String urlConexao) {
        try {
            Connection connection = connect(urlConexao);
            Statement stmt = connection.createStatement();

            ResultSet result = stmt.executeQuery("SELECT * FROM cliente;");

            while (result.next()) {
                System.out.print("Id = " + result.getInt("id") + "\t");
                System.out.print("Nome = " + result.getString("nome") + "\t");
                System.out.print("Idade = " + result.getInt("idade")+ "\t");
                System.out.print("CPF = " + result.getString("cpf")+ "\t");
                System.out.println("CPF = " + result.getString("rg"));
            }
            System.out.println();
            stmt.close();
            connection.close();
        } catch (SQLException e) {
            System.out.println("Não foi possível selecionar todos os dados!");
        }
    }

    public void update(String urlConexao, int id, String name, Integer idade) {
        try {
            Connection connection = connect(urlConexao);
            Statement stmt = connection.createStatement();

            String query = "UPDATE cliente SET nome = '" + name + "', idade = " + idade + " WHERE id = " + id + ";";

            stmt.executeUpdate(query);
            stmt.close();
            connection.close();

        } catch (SQLException e) {
            e.printStackTrace(System.out);
            System.out.println("Não foi possível atualizar os dados!");
        }
    }

    public void delete(String urlConexao, int id) {
        try {
            Connection connection = connect(urlConexao);
            Statement stmt = connection.createStatement();

            String query = "DELETE FROM cliente WHERE id = " + id + ";";
            stmt.executeUpdate(query);
            stmt.close();
            connection.close();

        } catch (SQLException e) {
            System.out.println("Não foi possível deletar os dados!");
        }
    }
}