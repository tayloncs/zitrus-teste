package dao;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
public class Cadastro {
    private Autorizacao autorizacao;
    private Procedimento procedimento;


    public Cadastro(Long numProcedimento, String descricao, Integer idade, String sexo, boolean isAutorizado) {
        procedimento = Procedimento.builder().numProcedimento(numProcedimento).descricao(descricao).build();
        autorizacao = Autorizacao.builder().idProcedimento(numProcedimento).idade(idade).sexo(sexo)
            .permitido(isAutorizado).build();

    }
}
