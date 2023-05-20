package dao;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;


@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
public class Procedimento {
    private Long id;

    private Long numProcedimento;

    private String descricao;

    private LocalDateTime dataInclusao;

    private LocalDateTime dataAtualizacao;


}

