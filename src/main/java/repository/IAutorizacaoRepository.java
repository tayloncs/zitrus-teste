package repository;

import dao.Autorizacao;
import dao.Cadastro;

import java.sql.SQLException;

public interface IAutorizacaoRepository {

    Autorizacao findAutorizacao(Autorizacao autorizacao);

    void update(Autorizacao autorizacao);

    void save(Cadastro cadastro) throws SQLException;
}
