package service;

import dao.Cadastro;
import repository.AutorizacaoRepository;
import repository.IAutorizacaoRepository;
import repository.IProcedimentoRepository;
import repository.ProcedimentoRepository;

public class CadastroService {

    private final IProcedimentoRepository procedimentoRepository = new ProcedimentoRepository();
    private final IAutorizacaoRepository autorizacaoRepository = new AutorizacaoRepository();

    public boolean cadastrar(Cadastro cadastro) {
        try {
            procedimentoRepository.save(cadastro);
            autorizacaoRepository.save(cadastro);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

}
