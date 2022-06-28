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
            Statement stmt connection.createStatement();
            stmt.executeUpdate("DROP TABLE IF EXISTS cliente");

            stmt.executeUpdate("CREATE TABLE cliente (id INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT," +
                    " nome TEXT NOTNULL, idade INTEGER NOT NULL, cpf TEXT NOT NULL, rg TEXT NOT NULL)");
            stmt.close();
            connection.close();
        } catch (SQLException e) {
            System.out.println("Não foi possível criar tabela!");
        }
    }

    public void insert(String url_conexao, Cliente cliente) {
        try {
            Connection connection = connect(url_conexao);
            Statement stmt connection.createStatement();

            String query = "INSERT INTO cliente VALUES (null, " + cliente.getNome() + ", " + cliente.getIdade(), + ", " +
                    cliente.getCpf() + ", " + cliente.getRg() + ")";

            stmt.executeUpdate(query);
            stmt.close();
            connection.close();
        } catch (SQLException e) {
            System.out.println("Não foi possível inserir na tabela!");
        }
    }

    public void selectAll(String urlConexao) {
        try {
            Connection connection = connect(urlConexao);
            Statement stmt connection.createStatement();

            ResultSet result = stmt.executeQuery("SELECT * FROM cliente");

            stmt.close();
            connection.close();
        } catch (SQLException e) {
            System.out.println("Não foi possível selecionar todos os dados!");
        }
    }

    public void update(String urlConexao, int id, String name, Integer idade) {
        try {
            Connection connection = connect(urlConexao);
            Statement stmt connection.createStatement();

            String query = 'UPDATE cliente SET nome = "' + name + '", idade = ' + idade + 'WHERE id = ' + id;

            stmt.executeUpdate(query);
            stmt.close();
            connection.close();

        } catch (SQLException e) {
            System.out.println("Não foi possível atualizar os dados!");
        }
    }

    public void delete(String urlConexao, int id) {
        try {
            Connection connection = connect(urlConexao);
            Statement stmt connection.createStatement();

            query = "DELETE FROM cliente WHERE id = " + id;
            stmt.executeUpdate(query);
            stmt.close();
            connection.close();

        } catch (SQLException e) {
            System.out.println("Não foi possível deletar os dados!");
        }
    }
}