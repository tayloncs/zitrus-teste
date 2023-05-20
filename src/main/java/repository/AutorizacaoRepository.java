package repository;

import dao.Autorizacao;
import dao.Cadastro;
import utils.AppUtils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Objects;

public class AutorizacaoRepository implements IAutorizacaoRepository {
    private Connection connection;

    public AutorizacaoRepository() {
        try {
            connection = DriverManager.getConnection(
                AppUtils.getPropertyValue("url"),
                AppUtils.getPropertyValue("username"),
                AppUtils.getPropertyValue("password"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void save(Cadastro cadastro) throws SQLException {
        String query = "INSERT INTO Autorizacao (id_procedimento, idade, sexo, permitido, data_inclusao) " +
            "VALUES (?, ?, ?, ?, ?)";


        Autorizacao autorizacaoExistente = findAutorizacao(cadastro.getAutorizacao());

        if (Objects.nonNull(autorizacaoExistente)) {
            update(autorizacaoExistente);
        }

        try (PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setLong(1, cadastro.getProcedimento().getNumProcedimento());
            statement.setInt(2, cadastro.getAutorizacao().getIdade());
            statement.setString(3, cadastro.getAutorizacao().getSexo());
            statement.setBoolean(4, cadastro.getAutorizacao().isPermitido());
            statement.setTimestamp(5, new Timestamp(new Date().getTime()));

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new SQLException("Erro ao salvar procedimento");
        }

    }

    @Override
    public Autorizacao findAutorizacao(Autorizacao autorizacao) {
        String query = "SELECT * FROM Autorizacao WHERE id_procedimento = ? AND idade = ? AND sexo = ? " +
            "ORDER BY data_inclusao DESC LIMIT 1";

        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setLong(1, autorizacao.getIdProcedimento());
            statement.setInt(2, autorizacao.getIdade());
            statement.setString(3, autorizacao.getSexo());
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                return mapRowToAutorizacao(resultSet);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    private Autorizacao mapRowToAutorizacao(ResultSet resultSet) throws SQLException {
        Autorizacao autorizacao = new Autorizacao();
        try {
            autorizacao.setId(resultSet.getLong("id"));
            autorizacao.setIdProcedimento(resultSet.getLong("id_procedimento"));
            autorizacao.setIdade(resultSet.getInt("idade"));
            autorizacao.setSexo(resultSet.getString("sexo"));
            autorizacao.setPermitido(resultSet.getBoolean("permitido"));
            autorizacao.setDataInclusao(resultSet.getObject("data_inclusao", LocalDateTime.class));
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
        return autorizacao;
    }


    @Override
    public void update(Autorizacao autorizacao) {
        String query = "UPDATE Autorizacao SET data_atualizacao = ? WHERE id_procedimento = ? AND idade = ? AND sexo " +
            "= ?";

        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setTimestamp(1, new Timestamp(new Date().getTime()));
            statement.setLong(2, autorizacao.getIdProcedimento());
            statement.setInt(3, autorizacao.getIdade());
            statement.setString(4, autorizacao.getSexo());

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
