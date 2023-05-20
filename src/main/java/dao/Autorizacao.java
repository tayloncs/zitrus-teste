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
public class Autorizacao {
    private Long id;

    private Long idProcedimento;

    private Integer idade;

    private String sexo;

    private boolean permitido;

    private LocalDateTime dataInclusao;

    private LocalDateTime dataAtualizacao;


}

