package service;

import dao.Autorizacao;
import repository.AutorizacaoRepository;
import repository.IAutorizacaoRepository;

public class AutorizacaoService {

    private final IAutorizacaoRepository autorizacaoRepository = new AutorizacaoRepository();

    public Autorizacao consultar(Autorizacao autorizacao) {
        return autorizacaoRepository.findAutorizacao(autorizacao);
    }

}
