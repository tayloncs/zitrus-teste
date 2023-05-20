package repository;

import dao.Cadastro;
import dao.Procedimento;

import java.util.List;

public interface IProcedimentoRepository {
    Procedimento findByNumProcedimento(Integer numProcedimento);

    List<Procedimento> findAll();

    void save(Cadastro cadastro);
}

