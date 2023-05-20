package repository;

import dao.Cadastro;
import dao.Procedimento;
import org.apache.commons.lang3.ObjectUtils;
import utils.AppUtils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ProcedimentoRepository implements IProcedimentoRepository {
    private Connection connection;

    public ProcedimentoRepository() {
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
    public Procedimento findByNumProcedimento(Integer numProcedimento) {
        String query = "SELECT * FROM Procedimento WHERE num_procedimento = ?";

        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setLong(1, numProcedimento);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                return mapRowToProcedimento(resultSet);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public List<Procedimento> findAll() {
        String query = "SELECT * FROM Procedimento";
        List<Procedimento> procedimentos = new ArrayList<>();

        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {
            while (resultSet.next()) {
                Procedimento procedimento = mapRowToProcedimento(resultSet);
                procedimentos.add(procedimento);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return procedimentos;
    }

    @Override
    public void save(Cadastro cadastro) {
        String query = "INSERT INTO Procedimento (num_procedimento, descricao, data_inclusao) " +
            "SELECT ?, ?, ? FROM DUAL " +
            "WHERE NOT EXISTS (SELECT * FROM Procedimento WHERE num_procedimento = ?)";

        try (PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setLong(1, cadastro.getProcedimento().getNumProcedimento());
            statement.setString(2, cadastro.getProcedimento().getDescricao());
            statement.setTimestamp(3, new Timestamp(new Date().getTime()));
            statement.setLong(4, cadastro.getProcedimento().getNumProcedimento());

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    private Procedimento mapRowToProcedimento(ResultSet resultSet) throws SQLException {
        Procedimento procedimento = new Procedimento();
        try {
            procedimento.setId(resultSet.getLong("id"));
            procedimento.setNumProcedimento(resultSet.getLong("num_procedimento"));
            procedimento.setDescricao(resultSet.getString("descricao"));
            procedimento.setDataInclusao(resultSet.getTimestamp("data_inclusao").toLocalDateTime());
            procedimento.setDataAtualizacao(
                ObjectUtils.requireNonEmpty(resultSet.getTimestamp("data_atualizacao")).toLocalDateTime());
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
        return procedimento;
    }
}

